package ru.msu.cmc.spacegallery.data.repositories

import ru.msu.cmc.spacegallery.data.datastores.NetworkGalleryDataStore
import ru.msu.cmc.spacegallery.data.mappers.GalleryItemConverter
import ru.msu.cmc.spacegallery.models.GalleryItem

class GalleryRepositoryImpl(
    private val dataStore: NetworkGalleryDataStore,
    private val galleryItemConverter: GalleryItemConverter
) : GalleryRepository {

    override suspend fun getGallery(count: Int): List<GalleryItem> =
        dataStore.getGallery(count).let {
            galleryItemConverter.convertList(it)
        }
}