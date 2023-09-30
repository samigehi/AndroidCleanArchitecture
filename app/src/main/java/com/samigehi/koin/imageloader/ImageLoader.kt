package com.samigehi.koin.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.samigehi.koin.R

/**
 * Custom ImageLoader, In future if we want to change the the library/Implementation, we need to change only here and other classes will not affect
 */
object ImageLoader {

    fun load(url: String?, imageView: ImageView?) {
        imageView?.let {
            Glide.with(imageView)
                .applyDefaultRequestOptions(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(url).error(R.drawable.ic_default_image_24).into(imageView)
        }
    }

}