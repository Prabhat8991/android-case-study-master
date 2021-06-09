package com.target.targetcasestudy.data.source.network

import com.target.targetcasestudy.domain.model.response.DealNetworkModel

interface NetworkDataSource {
    suspend fun getDeals(): List<DealNetworkModel>?
}