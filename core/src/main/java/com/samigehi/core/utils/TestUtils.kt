package com.samigehi.core.utils

import com.samigehi.core.data.source.remote.response.classified.ClassifiedEntity
import com.samigehi.core.data.source.remote.response.classified.Classifieds
import com.samigehi.core.domain.models.Classified
import java.util.*
import kotlin.collections.ArrayList

class TestUtils {
    companion object {

        fun getMockedClassified(): Classified {
            val images = ArrayList<String>()
            images.add(
                "https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4WWUURG5T&Signature=CcxSTKCtPKeUzzG%2FFzFnxbo2Cj0%3D&x-amz-security-token=IQoJb3JpZ2luX2VjENn%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJHMEUCIQCMbH0Ub0pVxodJ1Qjky8Nl4zw71pCUxSliC%2Bg5vPytogIgGigEHxhL%2B6hd1QamH%2FUvo2yBtrGeT3a1aTQQnScDXcUq1wEI0v%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARACGgwxODQzOTg5NjY4NDEiDJNeauUM5tATXJfC1yqrAZ19CBg92sEJv0e8n8uljucHEaZkAFYHkJNWoLcy0pSgVbUDUCi6FoYqyJ2iwm7JjqWwNHY00mwq%2Bp%2Fr2LdHIqdxexu7ZMb3JMtRBKJfi2efLEQsaDJ4P2ZlSp6ekSYKv9fXzOj2wtDg4bnTga3XeFaE%2FaqChE4aBLS1cX4b73FFi4lolGT5DqxUZjq4ZALjVyuUfTw%2FbAoxFBHuikw4daqfC5uPTCJKghCQqDCg%2BJiBBjrgAXzypBi8nhGWKDN84%2FazjtmbXPhjp%2FfR8x1aMKplXIqgcsczI3BRa0Xjowb0U2ia5THHS4LDj0Kia7bh1JIebu0oDpHpCeAdCQVCUucARdf%2Bmj3z0VOfQbh6k2doQ9lka%2F%2BBFLji%2B7IIuJhrlhvqLFEv%2Bey6IsD5YDXtKuadzqNSUdcOI43lymvTB%2F%2FfmZvlYHe7F1QKzhzxoGBKJ%2F70WbFuQfTFVUgIamvMsKXtOP1ERwWLgbbklGyDdQhZxW6UouwFch6XcCx8Keq%2BPbXt0PKlRd%2FBuoXBh924%2FuNP6OyY&Expires=1613123305"
            )
            return Classified(
                "1234",
                "MacBook Pro 2018",
                "AED 4,500",
                Date().toString(),
                images,
                images,
                images
            )
        }

        fun getMockedClassifiedEntity(): ClassifiedEntity {
            val images = ArrayList<String>()
            images.add(
                "https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4WWUURG5T&Signature=CcxSTKCtPKeUzzG%2FFzFnxbo2Cj0%3D&x-amz-security-token=IQoJb3JpZ2luX2VjENn%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJHMEUCIQCMbH0Ub0pVxodJ1Qjky8Nl4zw71pCUxSliC%2Bg5vPytogIgGigEHxhL%2B6hd1QamH%2FUvo2yBtrGeT3a1aTQQnScDXcUq1wEI0v%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARACGgwxODQzOTg5NjY4NDEiDJNeauUM5tATXJfC1yqrAZ19CBg92sEJv0e8n8uljucHEaZkAFYHkJNWoLcy0pSgVbUDUCi6FoYqyJ2iwm7JjqWwNHY00mwq%2Bp%2Fr2LdHIqdxexu7ZMb3JMtRBKJfi2efLEQsaDJ4P2ZlSp6ekSYKv9fXzOj2wtDg4bnTga3XeFaE%2FaqChE4aBLS1cX4b73FFi4lolGT5DqxUZjq4ZALjVyuUfTw%2FbAoxFBHuikw4daqfC5uPTCJKghCQqDCg%2BJiBBjrgAXzypBi8nhGWKDN84%2FazjtmbXPhjp%2FfR8x1aMKplXIqgcsczI3BRa0Xjowb0U2ia5THHS4LDj0Kia7bh1JIebu0oDpHpCeAdCQVCUucARdf%2Bmj3z0VOfQbh6k2doQ9lka%2F%2BBFLji%2B7IIuJhrlhvqLFEv%2Bey6IsD5YDXtKuadzqNSUdcOI43lymvTB%2F%2FfmZvlYHe7F1QKzhzxoGBKJ%2F70WbFuQfTFVUgIamvMsKXtOP1ERwWLgbbklGyDdQhZxW6UouwFch6XcCx8Keq%2BPbXt0PKlRd%2FBuoXBh924%2FuNP6OyY&Expires=1613123305"
            )
            return ClassifiedEntity(
                Date().toString(),
                images,
                images,
                images,
                "MacBook Pro 2018",
                "AED 4,500",
                "1256"
            )
        }


        fun getClassifedList(): Classifieds {
            val list = ArrayList<ClassifiedEntity>()
            val images = ArrayList<String>()
            images.add(
                "https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4WWUURG5T&Signature=CcxSTKCtPKeUzzG%2FFzFnxbo2Cj0%3D&x-amz-security-token=IQoJb3JpZ2luX2VjENn%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJHMEUCIQCMbH0Ub0pVxodJ1Qjky8Nl4zw71pCUxSliC%2Bg5vPytogIgGigEHxhL%2B6hd1QamH%2FUvo2yBtrGeT3a1aTQQnScDXcUq1wEI0v%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARACGgwxODQzOTg5NjY4NDEiDJNeauUM5tATXJfC1yqrAZ19CBg92sEJv0e8n8uljucHEaZkAFYHkJNWoLcy0pSgVbUDUCi6FoYqyJ2iwm7JjqWwNHY00mwq%2Bp%2Fr2LdHIqdxexu7ZMb3JMtRBKJfi2efLEQsaDJ4P2ZlSp6ekSYKv9fXzOj2wtDg4bnTga3XeFaE%2FaqChE4aBLS1cX4b73FFi4lolGT5DqxUZjq4ZALjVyuUfTw%2FbAoxFBHuikw4daqfC5uPTCJKghCQqDCg%2BJiBBjrgAXzypBi8nhGWKDN84%2FazjtmbXPhjp%2FfR8x1aMKplXIqgcsczI3BRa0Xjowb0U2ia5THHS4LDj0Kia7bh1JIebu0oDpHpCeAdCQVCUucARdf%2Bmj3z0VOfQbh6k2doQ9lka%2F%2BBFLji%2B7IIuJhrlhvqLFEv%2Bey6IsD5YDXtKuadzqNSUdcOI43lymvTB%2F%2FfmZvlYHe7F1QKzhzxoGBKJ%2F70WbFuQfTFVUgIamvMsKXtOP1ERwWLgbbklGyDdQhZxW6UouwFch6XcCx8Keq%2BPbXt0PKlRd%2FBuoXBh924%2FuNP6OyY&Expires=1613123305"
            )
            val item = ClassifiedEntity(
                Date().toString(),
                images,
                images,
                images,
                "MacBook Pro 2018",
                "AED 4,500",
                "1256"
            )
            for (i in 0..10)
                list.add(item)

            return Classifieds(null, list)
        }
    }
}