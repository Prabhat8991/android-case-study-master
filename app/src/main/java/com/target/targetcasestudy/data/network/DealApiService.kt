package com.target.targetcasestudy.data.network

import com.target.targetcasestudy.domain.model.response.DealListNetworkContainer
import com.target.targetcasestudy.domain.model.response.DealNetworkModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface DealApiService {
    @GET("/mobile_case_study_deals/v1/deals")
    fun getDeals(): Deferred<DealListNetworkContainer>
}