package com.samigehi.koin.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.samigehi.core.data.source.ClassifiedResource
import com.samigehi.core.domain.models.Classified
import com.samigehi.core.utils.Logger
import com.samigehi.koin.R
import com.samigehi.koin.adapters.ClassifiedAdapter
import com.samigehi.koin.listeners.ItemClickListener
import com.samigehi.koin.ui.base.BaseActivity
import com.samigehi.koin.utils.Utils
import com.samigehi.koin.utils.gone
import com.samigehi.koin.utils.visible
import com.samigehi.koin.viewmodel.ClassifiedViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {


    private val homeViewModel: ClassifiedViewModel by viewModel()
    var time = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment(), "home_fragment")
    }

    suspend fun test() {
        com.samigehi.core.utils.Logger.e("flow<Any> test start")

        flow<String> {
            com.samigehi.core.utils.Logger.e("flow<Any> ")
            emit("emit test")
            com.samigehi.core.utils.Logger.e("flow<Any> emt ")
            withContext(Dispatchers.IO) {
                emit("emit2 test")
                com.samigehi.core.utils.Logger.e("flow<Any> emt2 ")
            }
            val data = homeViewModel.classified
            com.samigehi.core.utils.Logger.e("flow<Any> data ${data.value?.data}")
            emit("emit final")
        }.flowOn(Dispatchers.IO).collect {
            com.samigehi.core.utils.Logger.e("flow<Any> data collect $it")
        }
    }

    fun test2() {
        com.samigehi.core.utils.Logger.e("flow<Any> test2 start")
        runBlocking {
            com.samigehi.core.utils.Logger.e("flow<Any> test2 runBlocking")
            val f = homeViewModel.raw.first()
            com.samigehi.core.utils.Logger.e("flow<Any> test2 first $f")

//            homeViewModel.raw.collect {
//                com.samigehi.core.utils.Logger.e("flow<Any> test2 collect $it")
//                com.samigehi.core.utils.Logger.e("flow<Any> test2 collect ${it.data}")
//
//            }
            com.samigehi.core.utils.Logger.e("flow<Any> test2 runBlocking end")

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




}