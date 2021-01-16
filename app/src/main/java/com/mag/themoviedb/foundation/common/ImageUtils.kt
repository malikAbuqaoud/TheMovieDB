package com.mag.themoviedb.foundation.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mag.themoviedb.R
import com.mag.themoviedb.foundation.client.ApiConstant.IMAGE_BASE_URL
import com.mag.themoviedb.foundation.client.ApiConstant.IMAGE_W500_BASE_URL

fun ImageView.loadImage(path: String, imageType: ImageType = ImageType.ORIGINAL) {
    Glide.with(context)
        .load(imageUrl(path, imageType))
        .placeholder(R.drawable.ic_baseline_image_24)
        .error(R.drawable.ic_baseline_broken_image_24)
        .into(this)
}

private fun imageUrl(path: String, imageType: ImageType) =
    when (imageType) {
        ImageType.ORIGINAL -> IMAGE_BASE_URL + path
        ImageType.W500 -> IMAGE_W500_BASE_URL + path
    }
