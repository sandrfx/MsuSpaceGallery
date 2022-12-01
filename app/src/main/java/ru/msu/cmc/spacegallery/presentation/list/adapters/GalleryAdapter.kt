package ru.msu.cmc.spacegallery.presentation.list.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.msu.cmc.spacegallery.R
import ru.msu.cmc.spacegallery.models.GalleryItem

class GalleryAdapter(private val dataSet: List<GalleryItem>): RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imagePreview: ImageView
        val tvTitle: TextView
        val tvDate: TextView

        init {
            imagePreview = view.findViewById(R.id.imgPreview)
            tvTitle = view.findViewById(R.id.tvTitle)
            tvDate = view.findViewById(R.id.tvDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            dataSet[position].let {
                Glide.with(imagePreview.context).load(it.imageUrl).into(imagePreview)
                tvTitle.text = it.title
                tvDate.text = it.date
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size
}