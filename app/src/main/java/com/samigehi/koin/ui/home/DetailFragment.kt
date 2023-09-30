package com.samigehi.koin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.samigehi.core.domain.models.Classified
import com.samigehi.koin.R
import com.samigehi.koin.adapters.ImageSliderAdapter
import com.samigehi.koin.databinding.FragmentItemDetailsBinding
import com.samigehi.koin.ui.base.BaseFragment
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class DetailFragment : BaseFragment() {

    companion object {
        fun get(data: Classified?): DetailFragment {
            val bundle = Bundle()
            bundle.putSerializable("classified_data", data)
            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    var binding: FragmentItemDetailsBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentItemDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("classified_data") as Classified?

        if (data == null || data.name.isNullOrEmpty() || data.price.isNullOrEmpty()) {
            doOnUI {
                Toast.makeText(context, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
            }
            // handle error
            return
        }
        binding?.imageSlider?.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding?.imageSlider?.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding?.imageSlider?.startAutoCycle();
        val list = ArrayList<String>()
        val images = data.imageUrls
        if (images != null)
            for (image in images) {
                image?.let {
                    list.add(it)
                }
            }
        com.samigehi.core.utils.Logger.e("images $list")
        binding?.imageSlider?.setSliderAdapter(ImageSliderAdapter(list))
        binding?.tvTitle?.text = data.name
        binding?.tvPrice?.text = data.price
        binding?.tvDate?.text = data.createdAt
        binding?.tvLocation?.text = "Dubai"
    }
}