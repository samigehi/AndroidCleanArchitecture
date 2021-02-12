package com.dubizzle.classified.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dubizzle.classified.adapters.ImageSliderAdapter
import com.dubizzle.core.domain.models.Classified
import com.dubizzle.classified.R
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_item_details.*

class ClassifiedDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_item_details)

        val data = intent?.getSerializableExtra("classified_data") as Classified?

        if (data == null || data.name.isNullOrEmpty() || data.price.isNullOrEmpty()) {
            Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT)
                .show()
            finish()
            return
        }
        imageSlider?.setIndicatorAnimation(IndicatorAnimationType.WORM);
        imageSlider?.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider?.startAutoCycle();
        val list = ArrayList<String>()
        val images = data.imageUrls
        if (images != null)
            for (image in images) {
                image?.let {
                    list.add(it)
                }
            }
        com.dubizzle.core.utils.Logger.e("images $list")
        imageSlider?.setSliderAdapter(ImageSliderAdapter(list))
        tv_title?.text = data.name
        tv_price?.text = data.price
        tv_date?.text = data.createdAt
        tv_location?.text = "Dubai"
    }
}