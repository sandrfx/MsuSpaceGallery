package ru.msu.cmc.spacegallery.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import ru.msu.cmc.spacegallery.R
import ru.msu.cmc.spacegallery.data.datastores.NetworkGalleryDataStore
import ru.msu.cmc.spacegallery.data.mappers.GalleryItemConverterImpl
import ru.msu.cmc.spacegallery.data.network.RetrofitBuilder
import ru.msu.cmc.spacegallery.data.repositories.GalleryRepository
import ru.msu.cmc.spacegallery.data.repositories.GalleryRepositoryImpl
import ru.msu.cmc.spacegallery.models.GalleryItem
import ru.msu.cmc.spacegallery.presentation.details.FragmentGalleryDetails
import ru.msu.cmc.spacegallery.presentation.list.adapters.GalleryAdapter

class FragmentGalleryList : Fragment(R.layout.fmt_gallery_list), OnGalleryItemClicked {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        val repository: GalleryRepository = GalleryRepositoryImpl(
            NetworkGalleryDataStore(RetrofitBuilder.galleryService),
            GalleryItemConverterImpl()
        )

        val galleryAdapter = GalleryAdapter(this)
        recycler.adapter = galleryAdapter

        CoroutineScope(Dispatchers.IO).launch {
            val result = repository.getGallery(20)
            withContext(Dispatchers.Main) {
                galleryAdapter.addItems(result)
            }
        }
    }

    override fun onGalleryItemClicked(galleryItem: GalleryItem) {
        parentFragmentManager.beginTransaction()
            .add(R.id.fmt_container, FragmentGalleryDetails.createFragment(galleryItem))
            .addToBackStack(null)
            .commit()
    }
}