package ru.msu.cmc.spacegallery.data.mappers

import ru.msu.cmc.spacegallery.data.models.network.GalleryDto
import ru.msu.cmc.spacegallery.models.GalleryItem

class GalleryItemConverterImpl : GalleryItemConverter {

    override fun convert(dto: GalleryDto): GalleryItem =
        GalleryItem(
            copyright = dto.copyright,
            date = dto.date,
            explanation = dto.explanation,
            hdImageUrl = dto.hdUrl,
            imageUrl = dto.url,
            title = dto.title
        )

    override fun convertList(list: List<GalleryDto>): List<GalleryItem> = list.map { convert(it) }
}