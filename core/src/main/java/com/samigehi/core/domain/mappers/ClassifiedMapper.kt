package com.samigehi.core.domain.mappers

import com.samigehi.core.data.source.remote.response.classified.ClassifiedEntity
import com.samigehi.core.domain.models.Classified

object ClassifiedMapper {

    /**
     * Convert repository model to app model, in repository may be we have extra parameters, which are not required for app
     */
    fun toClassified(classified: ClassifiedEntity?): Classified {
        return Classified(
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