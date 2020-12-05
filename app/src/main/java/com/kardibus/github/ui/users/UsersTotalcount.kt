package com.kardibus.github.ui.users

import androidx.databinding.ObservableField
import com.example.githubapp.models.ResultUsers

class UsersTotalcount(totalcount: ResultUsers) {
    var totalCount: ObservableField<Long?> = ObservableField(totalcount.total_count)
}