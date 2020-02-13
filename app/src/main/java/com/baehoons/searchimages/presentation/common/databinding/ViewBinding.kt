package com.baehoons.searchimages.presentation.common.databinding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isSelected")
fun isSelected(view: View, isSelected: Boolean) {
    view.isSelected = isSelected
}