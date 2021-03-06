package com.baehoons.searchimages.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    companion object {
        private const val ARGUMENT_ACTIVITY_IS_CREATED = "ARGUMENT_ACTIVITY_IS_CREATED"
    }

    protected lateinit var binding: B
        private set

    protected var isActivityFirstCreate: Boolean = true
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        checkActivityFirstCreate(savedInstanceState)
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView<B>(this, getLayoutId()).apply {
            lifecycleOwner = this@BaseActivity
        }
    }

    private fun checkActivityFirstCreate(savedInstanceState: Bundle?) {
        isActivityFirstCreate = savedInstanceState?.getBoolean(ARGUMENT_ACTIVITY_IS_CREATED)?.not() ?: true
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putBoolean(ARGUMENT_ACTIVITY_IS_CREATED, true)
    }

    protected fun showToast(message: String?) {
        message?.let { Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show() }
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}