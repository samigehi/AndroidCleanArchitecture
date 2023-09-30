package com.samigehi.core.data.source.remote.response.classified


import com.samigehi.core.data.model.BaseModel
import com.google.gson.annotations.SerializedName

data class Classifieds(
    @SerializedName("pagination")
    val pagination: Pagination?,
    @SerializedName("results")
    val results: List<ClassifiedEntity?>?
) : BaseModel {


}