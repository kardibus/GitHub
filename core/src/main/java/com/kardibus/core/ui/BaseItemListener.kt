package com.kardibus.core.ui

interface BaseItemListener<T> {
    fun onItemClick(item:T)
    fun onRetryClick()
}