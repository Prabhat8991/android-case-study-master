package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.domain.model.response.DealNetworkModel

interface DealsRepository {
    suspend fun refreshDeals(): List<DealNetworkModel>
}