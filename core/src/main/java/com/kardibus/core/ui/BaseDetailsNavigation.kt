package com.kardibus.core.ui

interface BaseDetailsNavigation<T> {
    fun handleError(message: String?)
    fun setData(data: List<Any>)
}