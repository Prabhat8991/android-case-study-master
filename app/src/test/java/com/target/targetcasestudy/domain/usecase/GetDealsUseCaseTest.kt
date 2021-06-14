package com.target.targetcasestudy.domain.usecase

import com.target.targetcasestudy.TestCoroutineRule
import com.target.targetcasestudy.data.mapper.ApiErrorMapper
import com.target.targetcasestudy.data.repository.DealsRepository
import com.target.targetcasestudy.domain.model.response.AmountDetails
import com.target.targetcasestudy.domain.model.response.DealNetworkModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetDealsUseCaseTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var apiErrorMapper: ApiErrorMapper

    lateinit var  getDealsUseCase: GetDealsUseCase

    @Test
    fun `test when get deals api return success`() {
        var result = 0
        val testObject =  DealNetworkModel(
            id = 1,
            title = "test title",
            description = "test description",
            aisle = "test aisle",
            regular_price = AmountDetails(amount_in_cents = "123"),
            image_url = "image_url"
        )


        testCoroutineRule.testDispatcher.runBlockingTest {
            val dealsRepository = mockk<DealsRepository>()
            coEvery { dealsRepository.refreshDeals() } returns listOf(testObject)
            getDealsUseCase = GetDealsUseCase(apiErrorMapper, dealsRepository, testCoroutineRule.testDispatcherProvider)
            getDealsUseCase.execute {
                onComplete {
                    result = it.first().id?: -1
                }
            }
            assertEquals(1, result)
        }
    }

}