package ru.msu.cmc.spacegallery.presentation.list

import ru.msu.cmc.spacegallery.models.GalleryItem

interface OnGalleryItemClicked {

    fun onGalleryItemClicked(galleryItem: GalleryItem)
}