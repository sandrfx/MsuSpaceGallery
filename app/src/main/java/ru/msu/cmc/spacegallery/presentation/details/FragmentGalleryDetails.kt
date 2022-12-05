package ru.msu.cmc.spacegallery.presentation.details

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.msu.cmc.spacegallery.R
import ru.msu.cmc.spacegallery.models.GalleryItem

class FragmentGalleryDetails : Fragment(R.layout.fmt_gallery_details) {

    companion object {
        private const val ARG_COPYRIGHT = "ARG_COPYRIGHT"
        private const val ARG_DATE = "ARG_DATE"
        private const val ARG_EXPLANATION = "ARG_EXPLANATION"
        private const val ARG_IMAGE_URL = "ARG_IMAGE_URL"
        private const val ARG_TITLE = "ARG_TITLE"

        fun createFragment(galleryItem: GalleryItem): FragmentGalleryDetails  {
            val fragment = FragmentGalleryDetails()

            fragment.arguments = Bundle().apply {
                putString(ARG_COPYRIGHT, galleryItem.copyright)
                putString(ARG_DATE, galleryItem.date)
                putString(ARG_EXPLANATION, galleryItem.explanation)
                putString(ARG_IMAGE_URL, galleryItem.imageUrl)
                putString(ARG_TITLE, galleryItem.title)
            }

            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageView>(R.id.imageView)
        val title = view.findViewById<TextView>(R.id.txtTitle)
        val author = view.findViewById<TextView>(R.id.txtAuthor)
        val date = view.findViewById<TextView>(R.id.txtDate)
        val desc = view.findViewById<TextView>(R.id.txtDesc)

        val args = requireArguments()

        Glide.with(this).load(args.getString(ARG_IMAGE_URL)).into(image)
        title.text = args.getString(ARG_TITLE, "")
        author.text = args.getString(ARG_COPYRIGHT, "")
        date.text = args.getString(ARG_DATE, "")
        desc.text = args.getString(ARG_EXPLANATION, "")
    }
}