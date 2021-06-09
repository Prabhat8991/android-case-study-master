package com.target.targetcasestudy.data.repository

import androidx.lifecycle.LiveData
import com.target.targetcasestudy.domain.model.response.DealDatabaseModel
import com.target.targetcasestudy.domain.model.response.DealNetworkModel

interface DealsRepository {
    suspend fun refreshDeals(): List<DealNetworkModel>
}