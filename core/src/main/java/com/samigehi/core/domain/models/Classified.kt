package com.samigehi.core.domain.models

import java.io.Serializable

data class Classified(
    var uid: String?, var name: String?,
    var price: String?,
    var createdAt: String? = null,
    var imageIds: List<String?>? = null,
    var imageUrls: List<String?>? = null,
    var imageUrlsThumbnails: List<String?>? = null
) : Serializable {

    fun search(query: String?): Boolean {
        return query != null && name?.toLowerCase()?.contains(query.toLowerCase()) ?: false
    }

}