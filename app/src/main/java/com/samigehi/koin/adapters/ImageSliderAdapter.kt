package com.samigehi.koin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.samigehi.koin.R
import com.samigehi.koin.imageloader.ImageLoader
import com.smarteist.autoimageslider.SliderViewAdapter


class ImageSliderAdapter(private var images: ArrayList<String>) :
    SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {


    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_slide_image, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(holder: SliderAdapterVH, position: Int) {
        val image = images[position]
        if (image.isNotEmpty())
           ImageLoader.load(image, holder.imageView)
        else holder.imageView?.setImageResource(R.drawable.ic_default_image_24)
    }

    override fun getCount(): Int {
        return images.size
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        val imageView: ImageView? = itemView.findViewById(R.id.iv_slider)
    }
}