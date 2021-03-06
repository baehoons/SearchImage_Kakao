package com.baehoons.searchimages.presentation.favorite

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.baehoons.searchimages.R
import com.baehoons.searchimages.databinding.ActivityFavoriteBinding
import com.baehoons.searchimages.extension.throttleFirstWithHalfSecond
import com.baehoons.searchimages.presentation.base.RxBaseActivity
import com.baehoons.searchimages.presentation.detail.ImageDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteImagesActivity : RxBaseActivity<ActivityFavoriteBinding>() {

    private val favoriteImagesViewModel: FavoriteImagesViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_favorite
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActionBar()

        initFavoriteListViewModel()
        initFavoriteRecyclerView()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initFavoriteListViewModel() {
        binding.favoriteListViewModel = favoriteImagesViewModel

        val owner = this
        with(favoriteImagesViewModel) {
            if(isActivityFirstCreate) {
                favoriteImagesViewModel.loadFavoriteImageList()
            }

            showMessageEvent.observe(owner, Observer { message ->
                showToast(message)
            })

            moveToDetailScreenEvent.observe(owner, Observer { imageDocument ->
                val imageDetailIntent = ImageDetailActivity.getImageDetailActivityIntent(owner, imageDocument)
                startActivity(imageDetailIntent)
            })
        }
    }

    private fun initFavoriteRecyclerView() {
        binding.favoriteRecyclerView.apply {
            adapter = FavoriteImagesAdapter().apply {
                itemClicks.throttleFirstWithHalfSecond()
                    .subscribe { imageDocument -> favoriteImagesViewModel.onClickImage(imageDocument) }
                    .disposeByOnDestroy()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                false
            }
        }
    }
}
