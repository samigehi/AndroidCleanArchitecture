package com.samigehi.core

import com.samigehi.koin.data.source.ClassifiedRepositoryImpl
import com.samigehi.koin.data.source.local.LocalDataSource
import com.samigehi.koin.data.source.remote.RemoteDataSource
import com.samigehi.koin.data.source.remote.network.ApiService
import com.samigehi.koin.utils.AppExecutors
import com.samigehi.koin.utils.Constant
import com.samigehi.koin.utils.TestUtils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*

class DomainTest {

    @Test
    fun testDomain() {
        val domain = com.samigehi.koin.utils.Constant.BASE_URL
        assertEquals(domain, "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/")
    }

    private lateinit var api: com.samigehi.koin.data.source.remote.network.ApiService
    private lateinit var remote: com.samigehi.koin.data.source.ClassifiedRepositoryImpl

    @Before
    fun before() {
        api = mock(com.samigehi.koin.data.source.remote.network.ApiService::class.java)
        val remoteMoviesDataStore = com.samigehi.koin.data.source.remote.RemoteDataSource(api)
        remote = com.samigehi.koin.data.source.ClassifiedRepositoryImpl(
            com.samigehi.koin.data.source.local.LocalDataSource(),
            remoteMoviesDataStore,
            com.samigehi.koin.utils.AppExecutors()
        )
    }


    @Test
    suspend fun testApi() {
        val list = com.samigehi.koin.utils.TestUtils.getClassifedList()
        `when`(api.getClassifieds()).thenReturn(list)
            .thenAnswer {
                it.arguments.size == 10
            }
    }

    @Test
    fun testApiResult() {
        val list = com.samigehi.koin.utils.TestUtils.getClassifedList()

    }

    @Test
    fun testUseCases() {
//        val list = TestUtils.getClassifedList()
//        val useCase = Mockito.mock(UseCase::class.java)
//        Mockito.`when`(useCase.getClassifieds()).thenReturn(flow {
//            list
//        }).assertComplete()
    }
}