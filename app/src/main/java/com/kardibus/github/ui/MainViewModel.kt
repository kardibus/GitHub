package com.kardibus.github.ui

import android.app.Application
import com.kardibus.github.data.AppDataManager
import com.kardibus.github.ui.base.BaseViewModel


class MainViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<Any>(application, appDataManager)