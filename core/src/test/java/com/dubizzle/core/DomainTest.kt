package com.dubizzle.core

import com.dubizzle.core.data.source.ClassifiedRepositoryImpl
import com.dubizzle.core.data.source.local.LocalDataSource
import com.dubizzle.core.data.source.remote.RemoteDataSource
import com.dubizzle.core.data.source.remote.network.ApiService
import com.dubizzle.core.usecases.UseCase
import com.dubizzle.core.utils.AppExecutors
import com.dubizzle.core.utils.Constant
import com.dubizzle.core.utils.TestUtils
import kotlinx.coroutines.flow.flow
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*

class DomainTest {

    @Test
    fun testDomain() {
        val domain = Constant.BASE_URL
        assertEquals(domain, "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/")
    }

    private lateinit var api: ApiService
    private lateinit var remote: ClassifiedRepositoryImpl

    @Before
    fun before() {
        api = mock(ApiService::class.java)
        val remoteMoviesDataStore = RemoteDataSource(api)
        remote = ClassifiedRepositoryImpl(LocalDataSource(), remoteMoviesDataStore, AppExecutors())
    }


    @Test
    suspend fun testApi() {
        val list = TestUtils.getClassifedList()
        `when`(api.getClassifieds()).thenReturn(list)
            .thenAnswer {
                it.arguments.size == 10
            }
    }

    @Test
    fun testApiResult() {
        val list = TestUtils.getClassifedList()

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