package com.target.targetcasestudy.ui.dealslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.domain.model.response.DealDatabaseModel
import com.target.targetcasestudy.domain.model.response.DealDomainModel
import com.target.targetcasestudy.domain.model.response.asDatabaseModel
import com.target.targetcasestudy.domain.model.response.asDomainModel
import com.target.targetcasestudy.domain.usecase.GetDealsUseCase
import com.target.targetcasestudy.domain.usecase.InsertUseCase
import javax.inject.Inject

class DealsViewModel @Inject constructor(
    private val getDealsUseCase: GetDealsUseCase,
    private val insertUseCase: InsertUseCase
) : ViewModel() {

    init {
        getDealsUseCase.execute {
            onComplete {
                insert(it.asDatabaseModel())
            }

            onError {
                Log.v("OnError", it.message)
            }

            onCancel {
                Log.v("OnCancel", it.message)
            }
        }
    }

    var dealDomainModel: LiveData<List<DealDomainModel>> = insertUseCase.deals

    var selectedDealModel: MutableLiveData<DealDomainModel> = MutableLiveData()

    fun setSelectedDealModel(dealDomainModel: DealDomainModel) {
        selectedDealModel.value = dealDomainModel
    }

    fun insert(listOfDealDatabaseModel: Array<DealDatabaseModel>) {
        insertUseCase.dealDatabaseModelList = listOfDealDatabaseModel
        insertUseCase.execute {
            onComplete {

            }
        }
    }
}