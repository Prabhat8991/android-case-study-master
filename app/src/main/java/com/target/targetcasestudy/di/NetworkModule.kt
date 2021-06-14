package com.target.targetcasestudy.di

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.target.targetcasestudy.core.Config
import com.target.targetcasestudy.data.network.DealApiService
import com.target.targetcasestudy.data.repository.DealRepositoryImpl
import com.target.targetcasestudy.data.repository.DealsRepository
import com.target.targetcasestudy.data.source.db.DealDao
import com.target.targetcasestudy.data.source.network.DealsNetworkDataSourceImpl
import com.target.targetcasestudy.data.source.network.NetworkDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addNetworkInterceptor(interceptor)
        return client.build()
    }

    @Provides
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    fun providesGsonConvertorFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideService(retrofit: Retrofit): DealApiService {
        return retrofit.create(DealApiService::class.java)
    }

    @Provides
    fun providesDealDataSource(dealApiService: DealApiService): NetworkDataSource {
        return DealsNetworkDataSourceImpl(dealApiService)
    }

    @Provides
    fun providesDealsRepository(networkDataSource: NetworkDataSource): DealsRepository = DealRepositoryImpl(networkDataSource)

}