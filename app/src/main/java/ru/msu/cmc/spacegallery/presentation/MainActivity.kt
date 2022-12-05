package ru.msu.cmc.spacegallery.presentation

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import ru.msu.cmc.spacegallery.R
import ru.msu.cmc.spacegallery.presentation.list.FragmentGalleryList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fmt_container, FragmentGalleryList())
                .commit()
        }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (supportFragmentManager.fragments.size > 1) {
                        supportFragmentManager.popBackStack()
                    } else {
                        finish()
                    }
                }
            }
        )
    }
}