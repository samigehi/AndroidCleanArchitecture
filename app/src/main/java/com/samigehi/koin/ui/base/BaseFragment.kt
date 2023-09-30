package com.samigehi.koin.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.samigehi.core.utils.Logger
import kotlinx.coroutines.*

abstract class BaseFragment : Fragment() {
    /// default coroutine scope for app based on Lifecycle of activity

    fun log(msg: String?){
        Logger.e("$msg")
    }

    /** [This][mainScope] coroutine scope will execute on [main looper thread][Looper.getMainLooper()].
     *  Use only for updating UI otherwise it will freeze/hang main thread.
     */
    fun mainScope(block: suspend CoroutineScope.() -> Unit) {
        lifecycle.coroutineScope.launch(
            context = Dispatchers.Main.immediate,
            start = CoroutineStart.DEFAULT,
            block = block
        )
    }

    /**
     * This coroutine scope will execute on IO thread in background
     * and designed for offloading blocking IO tasks to a shared pool of threads.
     * Additional threads in this pool are created and are shutdown on demand.
     *
     * If a task is running in background then this scope will cancel immediately once context of this activity is destroyed.
     * like when we call #[finish] or #[onDestroy], for applications scope use [globalScope]
     */
    fun ioScope(block: suspend CoroutineScope.() -> Unit) {
        lifecycle.coroutineScope.launch(Dispatchers.IO, block = block)
    }

    /**
     * This coroutine scope will execute on default shared pool threads in background and will cancel immediately once context of this activity is destroyed.
     *
     * like when we call [finish] or [onDestroy] then [defaultScope] will be destroyed too if task is running in background.
     */
    fun defaultScope(block: suspend CoroutineScope.() -> Unit) {
        lifecycle.coroutineScope.launch(Dispatchers.Default, block = block)
    }

    /**
     * This coroutine scope is not confined to any specific thread and will cancel immediately once context of this activity is destroyed.
     *
     * like when we call [finish] or [onDestroy] then [unconfinedScope] will cancel the task if it is running in background.
     */
    fun unconfinedScope(block: suspend CoroutineScope.() -> Unit) {
        lifecycle.coroutineScope.launch(Dispatchers.Unconfined, block = block)

    }

    /**
     * This coroutine scope will execute on default shared pool threads in background.
     * This scope will wait for completion, if task is running in background longer then this will cause memory-leaks.
     * for Activity scope use [defaultScope] or [ioScope]
     */
    // @DelicateCoroutinesApi
    fun globalScope(block: suspend CoroutineScope.() -> Unit) {
        GlobalScope.launch(Dispatchers.Default, block = block)
    }

    // alias for simplicity
    /**[mainScope] @see mainScope */
    fun doOnUI(block: suspend CoroutineScope.() -> Unit) {
        mainScope(block)
    }

    /**[defaultScope] @see defaultScope */
    fun doInBackground(block: suspend CoroutineScope.() -> Unit) {
        defaultScope(block)
    }
}