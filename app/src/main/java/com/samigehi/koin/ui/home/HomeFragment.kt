package com.samigehi.koin.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.samigehi.core.data.source.ClassifiedResource
import com.samigehi.core.domain.models.Classified
import com.samigehi.koin.R
import com.samigehi.koin.adapters.ClassifiedAdapter
import com.samigehi.koin.databinding.FragmentHomeBinding
import com.samigehi.koin.listeners.ItemClickListener
import com.samigehi.koin.ui.base.BaseFragment
import com.samigehi.koin.utils.Utils
import com.samigehi.koin.utils.gone
import com.samigehi.koin.utils.visible
import com.samigehi.koin.viewmodel.ClassifiedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


// this class is not fully functional, this class is just for representation purpose, how we can use fragments with binding and ViewModel, lifecycler aware events
class HomeFragment : BaseFragment() {

    private val viewModel: ClassifiedViewModel by viewModel()
    var binding: FragmentHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getClassified()

        binding?.swipeRefreshLayout?.setOnRefreshListener {
            getClassified()
        }
    }

    fun getClassified() {
        if (!Utils.isConnected(context)) {
            binding?.progressBar?.visibility = View.GONE
            binding?.emptyView?.visibility = View.VISIBLE
            binding?.emptyView?.setText(R.string.no_internet)
            binding?.swipeRefreshLayout?.isRefreshing = false
            return
        }
        if (viewModel.isLoading)
            return
        viewModel.isLoading = true
        binding?.progressBar?.visibility = View.VISIBLE
        log("onDataFetch start")
        // koin will fetch data automatically based on use-cases and notify to observer once done
        viewModel.classified.observe(viewLifecycleOwner, ::onDataFetch)
    }


    private fun onDataFetch(data: ClassifiedResource<List<Classified>>) {
        when (data) {
            is ClassifiedResource.Loading -> {
                binding?.progressBar?.visible()
            }
            is ClassifiedResource.Success -> {
                binding?.progressBar?.gone()
                val list = data.data
                if (list == null || list.isEmpty()) {
                    binding?.emptyView?.visible()
                    binding?.emptyView?.text = getString(R.string.no_data_found)
                } else {
                    binding?.emptyView?.gone()
                    setClassifiedAdapter(list)
                }
            }
            is ClassifiedResource.Error -> {
                binding?.emptyView?.visible()
                binding?.progressBar?.gone()
                binding?.emptyView?.text = getString(R.string.no_data_found)
            }
        }
    }

    private fun setClassifiedAdapter(results: List<Classified?>) {
        binding?.recyclerView?.layoutManager = GridLayoutManager(context, 2)
        val list = ArrayList<Classified>()
        for (item in results) {
            item?.let {
                list.add(it)
            }
        }

        if (list.isEmpty()) {
            binding?.emptyView?.visibility = View.VISIBLE
            binding?.emptyView?.text = getString(R.string.no_item_found)
            return
        }

        val adapter = ClassifiedAdapter(list, object : ItemClickListener<Classified?> {
            override fun onItemClick(item: Classified?, position: Int) {
                item?.let {
                    val intent = Intent(context, ClassifiedDetailActivity::class.java)
                    intent.putExtra("classified_data", it)
                    startActivity(intent)
                }
            }
        })

        binding?.recyclerView?.adapter = adapter

    }

}