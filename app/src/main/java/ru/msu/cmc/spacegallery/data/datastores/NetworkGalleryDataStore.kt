package ru.msu.cmc.spacegallery.data.datastores

import ru.msu.cmc.spacegallery.data.models.network.GalleryDto
import ru.msu.cmc.spacegallery.data.network.NasaGalleryService

class NetworkGalleryDataStore(
    private val nasaGalleryService: NasaGalleryService,
) {
    suspend fun getGallery(count: Int): List<GalleryDto> = nasaGalleryService.getGallery(count)
}