package ru.msu.cmc.spacegallery.data.mappers

import ru.msu.cmc.spacegallery.data.models.network.GalleryDto
import ru.msu.cmc.spacegallery.models.GalleryItem

interface GalleryItemConverter {

    fun convert(dto: GalleryDto): GalleryItem

    fun convertList(list: List<GalleryDto>): List<GalleryItem>
}