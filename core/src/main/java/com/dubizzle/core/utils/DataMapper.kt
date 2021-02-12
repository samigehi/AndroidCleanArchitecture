package com.dubizzle.core.utils

import com.dubizzle.core.data.source.remote.response.classified.ClassifiedEntity
import com.dubizzle.core.domain.mappers.ClassifiedMapper
import com.dubizzle.core.domain.models.Classified

object DataMapper {

    fun mapDomain(source: List<ClassifiedEntity?>): List<Classified> {
        val list = ArrayList<Classified>()
        source.map {
            list.add(ClassifiedMapper.toClassified(it))
        }
        return list
    }
}