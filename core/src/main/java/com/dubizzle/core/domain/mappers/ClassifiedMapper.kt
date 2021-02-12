package com.dubizzle.core.domain.mappers

import com.dubizzle.core.data.source.remote.response.classified.ClassifiedEntity

object ClassifiedMapper {

    fun toClassified(classified: ClassifiedEntity?): com.dubizzle.core.domain.models.Classified {
        return com.dubizzle.core.domain.models.Classified(
            classified?.uid,
            classified?.name,
            classified?.price,
            classified?.createdAt,
            classified?.imageIds,
            classified?.imageUrls,
            classified?.imageUrlsThumbnails
        )
    }


}