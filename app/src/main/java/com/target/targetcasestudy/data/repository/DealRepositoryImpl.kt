package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.source.network.NetworkDataSource
import com.target.targetcasestudy.domain.model.response.*
import javax.inject.Inject

class DealRepositoryImpl @Inject constructor(
    private val dataSource: NetworkDataSource
): DealsRepository {

    override suspend fun refreshDeals(): List<DealNetworkModel> {
        return dataSource.getDeals()?: emptyList()
    }
}