package ru.msu.cmc.spacegallery.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.msu.cmc.spacegallery.R
import ru.msu.cmc.spacegallery.data.datastores.MockGalleryDataStore
import ru.msu.cmc.spacegallery.data.repositories.GalleryRepository
import ru.msu.cmc.spacegallery.data.repositories.GalleryRepositoryImpl
import ru.msu.cmc.spacegallery.presentation.list.adapters.GalleryAdapter

class FragmentGalleryList : Fragment(R.layout.fmt_gallery_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        val repository: GalleryRepository = GalleryRepositoryImpl(MockGalleryDataStore())

        recycler.adapter = GalleryAdapter(repository.getGallery())
    }
}