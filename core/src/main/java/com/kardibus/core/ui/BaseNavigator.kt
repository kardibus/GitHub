package com.kardibus.core.ui

interface BaseNavigator<T> {
    fun handleError(message: String?)
    fun setData(data:T)
    fun search()
    fun more()
    fun back()
}