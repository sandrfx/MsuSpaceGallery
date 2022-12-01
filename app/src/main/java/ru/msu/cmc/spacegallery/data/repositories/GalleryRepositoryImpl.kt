package ru.msu.cmc.spacegallery.data.repositories

import ru.msu.cmc.spacegallery.data.datastores.MockGalleryDataStore
import ru.msu.cmc.spacegallery.models.GalleryItem

class GalleryRepositoryImpl(
    private val mockGalleryDS: MockGalleryDataStore
) : GalleryRepository {

    override fun getGallery(): List<GalleryItem> = mockGalleryDS.getGallery()
}