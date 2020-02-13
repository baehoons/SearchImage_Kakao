package com.baehoons.searchimages.di

import com.baehoons.searchimages.BuildConfig
import com.baehoons.searchimages.data.remote.kakao.KakaoSearchApi
import com.baehoons.searchimages.data.repository.image.ImageRemoteDataSource
import com.baehoons.searchimages.data.remote.kakao.ImageRemoteDataSourceImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single<ImageRemoteDataSource> {
        ImageRemoteDataSourceImpl(get())
    }

    single {
        get<Retrofit>().create(KakaoSearchApi::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }

    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get())
            addInterceptor(HttpLoggingInterceptor().apply {
                if(BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
        }.build()
    }

    single {
        Interceptor { chain ->
            chain.proceed(
                chain.request()
                    .newBuilder()
                    .header("Authorization", BuildConfig.KAKAO_API_KEY)
                    .build())
        }
    }

}