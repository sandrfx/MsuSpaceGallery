package ru.msu.cmc.spacegallery.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.msu.cmc.spacegallery.data.models.network.GalleryDto

interface NasaGalleryService {

    @GET("planetary/apod?api_key=DEMO_KEY")
    suspend fun getGallery(@Query("count") count: Int): List<GalleryDto>
}