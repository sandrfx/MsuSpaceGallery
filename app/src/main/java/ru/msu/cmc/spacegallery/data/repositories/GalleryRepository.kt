package ru.msu.cmc.spacegallery.data.repositories

import ru.msu.cmc.spacegallery.models.GalleryItem

interface GalleryRepository {

    fun getGallery(): List<GalleryItem>
}