package com.dubizzle.core

import com.dubizzle.core.domain.mappers.ClassifiedMapper
import com.dubizzle.core.utils.TestUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class MappersTest {

    @Test
    fun testMappingEntityToClassified() {

        val entity = TestUtils.getMockedClassifiedEntity()
        val classified = ClassifiedMapper.toClassified(entity);

        assertEquals(entity.uid, classified.uid)
        assertEquals(entity.name, classified.name)
        assertEquals(entity.price, classified.price)
        assertEquals(entity.createdAt, classified.createdAt)
    }
}