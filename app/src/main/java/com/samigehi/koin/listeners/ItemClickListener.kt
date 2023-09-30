package com.samigehi.koin.listeners

interface ItemClickListener<A> {

    fun onItemClick(item: A?, position: Int)

}