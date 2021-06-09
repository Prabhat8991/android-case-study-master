package com.target.targetcasestudy.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.target.targetcasestudy.data.repository.DealsRepository
import com.target.targetcasestudy.data.source.db.DealDao
import com.target.targetcasestudy.domain.model.response.*
import com.target.targetcasestudy.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class InsertUseCase @Inject constructor(
    private val dealDao: DealDao,
    dealsRepository: DealsRepository
): BaseUseCase<Unit>() {

    var dealDatabaseModelList = arrayOf<DealDatabaseModel>()

    val deals: LiveData<List<DealDomainModel>> =
        Transformations.map(dealDao.selectAllDeals()) {
            it.asDomainModel()
        }

    override suspend fun executionOnBackGround() {
       return dealDao.insertDeal(*dealDatabaseModelList)
    }
}