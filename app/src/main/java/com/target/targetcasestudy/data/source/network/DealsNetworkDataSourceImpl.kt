package com.target.targetcasestudy.data.source.network

import com.target.targetcasestudy.data.network.DealApiService
import com.target.targetcasestudy.domain.model.response.DealNetworkModel
import javax.inject.Inject

class DealsNetworkDataSourceImpl @Inject constructor(private val apiService: DealApiService): NetworkDataSource {
    override suspend fun getDeals(): List<DealNetworkModel>? {
        return apiService.getDeals().await().products
    }
}