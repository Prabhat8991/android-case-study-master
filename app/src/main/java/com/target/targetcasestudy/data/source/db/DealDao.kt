package com.target.targetcasestudy.data.source.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.target.targetcasestudy.domain.model.response.DealDatabaseModel

@Dao
interface DealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDeal(vararg dealDatabaseModel: DealDatabaseModel)

    @Query("SELECT * FROM dealdatabasemodel")
    fun selectAllDeals(): LiveData<List<DealDatabaseModel>>
}