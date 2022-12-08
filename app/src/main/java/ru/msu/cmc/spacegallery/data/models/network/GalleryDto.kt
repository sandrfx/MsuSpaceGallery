package ru.msu.cmc.spacegallery.data.models.network

import com.google.gson.annotations.SerializedName

data class GalleryDto(
    val copyright: String,
    val date: String?,
    val explanation: String?,
    @SerializedName("hdurl")
    val hdUrl: String?,
    val title: String?,
    val url: String?
)
