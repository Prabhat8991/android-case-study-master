package com.target.targetcasestudy.di

import android.app.Application
import androidx.room.Room
import com.target.targetcasestudy.data.source.db.AppDatabase
import com.target.targetcasestudy.data.source.db.DealDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesDealsDao(appDatabase: AppDatabase): DealDao {
        return appDatabase.dealDao
    }

}