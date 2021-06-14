package com.target.targetcasestudy.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.target.targetcasestudy.domain.model.response.DealDatabaseModel

@Database(entities = [DealDatabaseModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        const val DB_NAME = "deals.db"
        const val VERSION = 1
    }
    abstract val dealDao: DealDao
}
