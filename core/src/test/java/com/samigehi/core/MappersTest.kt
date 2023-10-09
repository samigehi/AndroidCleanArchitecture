package com.samigehi.core

import com.samigehi.koin.domain.mappers.ClassifiedMapper
import com.samigehi.koin.utils.TestUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class MappersTest {

    @Test
    fun testMappingEntityToClassified() {

        val entity = com.samigehi.koin.utils.TestUtils.getMockedClassifiedEntity()
        val classified = com.samigehi.koin.domain.mappers.ClassifiedMapper.toClassified(entity);

        assertEquals(entity.uid, classified.uid)
        assertEquals(entity.name, classified.name)
        assertEquals(entity.price, classified.price)
        assertEquals(entity.createdAt, classified.createdAt)
    }
}