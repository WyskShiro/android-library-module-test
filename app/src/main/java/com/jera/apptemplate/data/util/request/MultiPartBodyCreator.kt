package com.jera.apptemplate.data.util.request

import android.webkit.URLUtil
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class MultiPartBodyCreator {

    companion object {

        private const val IMAGE_TYPE = "image/"
        private const val APPLICATION_TYPE = "application/"

        private val imageKeys = arrayOf("avatar")
        private val documentKeys = arrayOf("document_records")

        fun execute(fields: Map<String, Any?>): MultipartBody {
            val builder = MultipartBody.Builder().setType(MultipartBody.FORM)
            for ((key, value) in fields) {
                when (key) {
                    in imageKeys -> addMediaToFormData(value, key, builder, IMAGE_TYPE)
                    in documentKeys -> addMediaToFormData(value, key, builder, APPLICATION_TYPE)
                    else -> if (value != null) builder.addFormDataPart(key, value.toString())
                }
            }
            return builder.build()
        }

        private fun addMediaToFormData(
            value: Any?,
            key: String,
            builder: MultipartBody.Builder,
            mediaType: String
        ) {
            val path = value as? String
            if (!(URLUtil.isHttpUrl(path) || URLUtil.isHttpsUrl(path))) {
                val file = File(path)
                builder.addFormDataPart(key, file.name, RequestBody.create(MediaType.parse(mediaType + file.extension), file))
            }
        }
    }
}
