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
import ru.msu.cmc.spacegallery.presentation.list.OnGalleryItemClicked

class GalleryAdapter(
    private val onClickAction: OnGalleryItemClicked
    ): RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private val dataSet: MutableList<GalleryItem> = mutableListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val itemCard: View
        val imagePreview: ImageView
        val tvTitle: TextView
        val tvDate: TextView

        init {
            itemCard = view.findViewById(R.id.itemCard)
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
                val galleryItem = it
                itemCard.setOnClickListener {
                    onClickAction.onGalleryItemClicked(galleryItem)
                }
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size

    fun addItems(items: List<GalleryItem>) {
        val start = dataSet.size
        dataSet.addAll(items)
        notifyItemInserted(start)
    }
}