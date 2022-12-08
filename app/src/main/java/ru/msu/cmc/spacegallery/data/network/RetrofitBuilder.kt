package ru.msu.cmc.spacegallery.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.nasa.gov/"

    val galleryService: NasaGalleryService = getRetrofit().create(NasaGalleryService::class.java)

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}