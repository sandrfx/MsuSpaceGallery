package ru.msu.cmc.spacegallery.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.msu.cmc.spacegallery.R
import ru.msu.cmc.spacegallery.presentation.list.FragmentGalleryList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fmt_container, FragmentGalleryList())
                .commit()
        }
    }
}