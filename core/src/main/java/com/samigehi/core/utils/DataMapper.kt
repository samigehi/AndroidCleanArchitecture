package com.samigehi.core.utils

import com.samigehi.core.data.source.remote.response.classified.ClassifiedEntity
import com.samigehi.core.domain.mappers.ClassifiedMapper
import com.samigehi.core.domain.models.Classified

object DataMapper {

    fun mapDomain(source: List<ClassifiedEntity?>): List<Classified> {
        val list = ArrayList<Classified>()
        source.map {
            list.add(ClassifiedMapper.toClassified(it))
        }
        return list
    }
}