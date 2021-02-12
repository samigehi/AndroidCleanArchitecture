package com.dubizzle.classified.ui.home

import android.content.Intent
import android.os.Bundle

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dubizzle.classified.R
import com.dubizzle.classified.adapters.ClassifiedAdapter
import com.dubizzle.classified.viewmodel.ClassifiedViewModel
import com.dubizzle.classified.listeners.ItemClickListener
import com.dubizzle.classified.utils.gone
import com.dubizzle.classified.utils.visible
import com.dubizzle.classified.utils.Utils
import com.dubizzle.core.data.source.ClassifiedResource
import com.dubizzle.core.domain.models.Classified
import com.dubizzle.core.utils.Logger
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {


    private val homeViewModel: ClassifiedViewModel by viewModel()
    var time = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSwipeRefresh(swipeRefreshLayout)

        getClassified()

        swipeRefreshLayout?.setOnRefreshListener {
            getClassified()
        }
//        et_search?.setOnEditorActionListener { v, actionId, event ->
//
//           // if(actionId === )
//        }
        runBlocking {
            com.dubizzle.core.utils.Logger.e("runBlocking test start")
            //   test()
        }

        test2()
    }

    suspend fun test() {
        com.dubizzle.core.utils.Logger.e("flow<Any> test start")

        flow<String> {
            com.dubizzle.core.utils.Logger.e("flow<Any> ")
            emit("emit test")
            com.dubizzle.core.utils.Logger.e("flow<Any> emt ")
            withContext(Dispatchers.IO) {
                emit("emit2 test")
                com.dubizzle.core.utils.Logger.e("flow<Any> emt2 ")
            }
            val data = homeViewModel.classified
            com.dubizzle.core.utils.Logger.e("flow<Any> data ${data.value?.data}")
            emit("emit final")
        }.flowOn(Dispatchers.IO).collect {
            com.dubizzle.core.utils.Logger.e("flow<Any> data collect $it")
        }
    }

    fun test2() {
        com.dubizzle.core.utils.Logger.e("flow<Any> test2 start")
        runBlocking {
            com.dubizzle.core.utils.Logger.e("flow<Any> test2 runBlocking")
            val f = homeViewModel.raw.first()
            com.dubizzle.core.utils.Logger.e("flow<Any> test2 first $f")

//            homeViewModel.raw.collect {
//                com.dubizzle.core.utils.Logger.e("flow<Any> test2 collect $it")
//                com.dubizzle.core.utils.Logger.e("flow<Any> test2 collect ${it.data}")
//
//            }
            com.dubizzle.core.utils.Logger.e("flow<Any> test2 runBlocking end")

        }
    }

    private fun setSwipeRefresh(refreshLayout: SwipeRefreshLayout?) {
        refreshLayout?.setColorSchemeResources(
            R.color.purple_200,
            R.color.teal_200,
            R.color.purple_700,
            R.color.teal_700,
            R.color.purple_500
        )
    }

    var isLoading = false

    private fun getClassified() {
        if (!Utils.isConnected(this)) {
            progressBar?.visibility = View.GONE
            empty_view?.visibility = View.VISIBLE
            empty_view?.setText(R.string.no_internet)
            swipeRefreshLayout?.isRefreshing = false
            return
        }
        if (isLoading)
            return
        isLoading = true
        progressBar?.visibility = View.VISIBLE
        Logger.e("onDataFetch start")
        homeViewModel.classified.observe(this, ::onDataFetch)
    }

    private fun onDataFetch(data: ClassifiedResource<List<Classified>>) {
        when (data) {
            is ClassifiedResource.Loading -> {
                progressBar?.visible()
            }
            is ClassifiedResource.Success -> {
                progressBar?.gone()
                val list = data.data
                if (list == null || list.isEmpty()) {
                    empty_view?.visible()
                    empty_view?.text = getString(R.string.no_data_found)
                } else {
                    empty_view?.gone()
                    setClassifiedAdapter(list)
                }
            }
            is ClassifiedResource.Error -> {
                empty_view?.visible()
                progressBar?.gone()
                empty_view?.text = getString(R.string.no_data_found)
            }
        }
    }

    private fun setClassifiedAdapter(results: List<Classified?>) {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val list = ArrayList<Classified>()
        for (item in results) {
            item?.let {
                list.add(it)
            }
        }

        if (list.isEmpty()) {
            empty_view?.visibility = View.VISIBLE
            empty_view?.text = getString(R.string.no_item_found)
            return
        }

        val adapter = ClassifiedAdapter(list, object : ItemClickListener<Classified?> {
            override fun onItemClick(item: Classified?, position: Int) {
                item?.let {
                    val intent = Intent(this@HomeActivity, ClassifiedDetailActivity::class.java)
                    intent.putExtra("classified_data", it)
                    startActivity(intent)
                }
            }
        })

        recyclerView?.adapter = adapter

    }
}