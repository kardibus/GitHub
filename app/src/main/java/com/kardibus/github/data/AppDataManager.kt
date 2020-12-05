package com.kardibus.github.data

import com.kardibus.github.data.local.db.DbRepository
import com.kardibus.github.data.local.prefs.PreferencesRepository
import com.kardibus.github.data.remote.ApiRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
    private val apiRepository: ApiRepository,
    private val dbRepository: DbRepository,
    private val preferencesRepository: PreferencesRepository
) {
    fun getApiRepository(): ApiRepository {
        return apiRepository
    }

    fun getDbRepository(): DbRepository {
        return dbRepository
    }

    fun getPreferencesRepository(): PreferencesRepository {
        return preferencesRepository
    }
}