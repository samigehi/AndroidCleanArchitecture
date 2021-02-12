package com.dubizzle.classified.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dubizzle.classified.R
import com.dubizzle.classified.imageloader.ImageLoader
import com.dubizzle.classified.listeners.ItemClickListener
import com.dubizzle.classified.utils.visible
import com.dubizzle.core.domain.models.Classified

class ClassifiedHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val icon = view.findViewById<ImageView?>(R.id.iv_thumbnail)
    private val name = view.findViewById<TextView?>(R.id.tv_title)
    private val price = view.findViewById<TextView?>(R.id.tv_price)
    private val location = view.findViewById<TextView?>(R.id.tv_location)
    private val feature = view.findViewById<TextView?>(R.id.tv_feature)
    private val time = view.findViewById<TextView?>(R.id.tv_time)

    fun bind(data: Classified, listener: ItemClickListener<Classified?>?) {
        // we can also use image slider here
        val list = data.imageUrlsThumbnails
        if (list != null && list.isNotEmpty()) {
            ImageLoader.load(list[0], icon)
        } else {
            icon?.setImageResource(R.drawable.ic_default_image_24)
        }

        name?.text = data.name
        price?.text = data.price
        time?.text = data.createdAt?.split(" ")?.get(0)?: ""
        location?.text = "Near you"
        feature?.visible(adapterPosition == 0 || adapterPosition == 1)

        itemView?.setOnClickListener {
            listener?.onItemClick(data, adapterPosition)
        }
    }
}