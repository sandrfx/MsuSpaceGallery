package ru.msu.cmc.spacegallery.data.repositories

import ru.msu.cmc.spacegallery.models.GalleryItem

interface GalleryRepository {

    suspend fun getGallery(count: Int): List<GalleryItem>
}