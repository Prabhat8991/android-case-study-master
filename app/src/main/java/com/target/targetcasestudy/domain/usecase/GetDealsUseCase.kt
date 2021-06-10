package com.target.targetcasestudy.domain.usecase

import com.target.targetcasestudy.data.mapper.ApiErrorMapper
import com.target.targetcasestudy.data.repository.DealsRepository
import com.target.targetcasestudy.domain.model.response.DealNetworkModel
import com.target.targetcasestudy.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class GetDealsUseCase @Inject constructor(
    apiErrorMapper: ApiErrorMapper,
    private val dealsRepository: DealsRepository,
    private val dispatcherProvider : DispatcherProvider = DefaultDispatcherProvider()
): BaseUseCase<List<DealNetworkModel>>(apiErrorMapper, dispatcherProvider) {

    override suspend fun executionOnBackGround(): List<DealNetworkModel> {
        return dealsRepository.refreshDeals()?: emptyList()
    }
}