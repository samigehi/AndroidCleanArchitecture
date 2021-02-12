package com.dubizzle.classified.listeners

interface ItemClickListener<A> {

    fun onItemClick(item: A?, position: Int)

}