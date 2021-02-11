package com.dubizzle.core.utils

import com.dubizzle.core.data.source.remote.response.classified.ClassifiedEntity
import com.dubizzle.core.domain.mappers.ClassifiedMapper
import com.dubizzle.core.domain.models.ClassifiedAd

object DataMapper {

    fun mapDomain(source: List<ClassifiedEntity?>): List<ClassifiedAd> {
        val list = ArrayList<ClassifiedAd>()
        source.map {
            list.add(ClassifiedMapper.toClassified(it))
        }
        return list
    }
}