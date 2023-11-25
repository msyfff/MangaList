package com.example.mangalist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.mangalist.databinding.ActivityMainBinding

class Pindah() : AppCompatActivity() {

    companion object {
        const val KEY_HERO = "key_hero"
//        const val NAME_MANGA = "name_manga"
//        const val DESC_MANGA = "desc_manga"
//        const val IMG_MANGA = "img_manga"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dalam)


        val dataManga = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_HERO, Manga::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_HERO)
        }

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo_dalam)
        val tvName: TextView = findViewById(R.id.tv_item_name_dalam)
        val desc: TextView = findViewById(R.id.tv_item_description_dalam)

//    val mangaName = intent.getStringExtra(NAME_MANGA)
//    val mangaDesc = intent.getStringExtra(DESC_MANGA)
//    val mangaImg = intent.getIntExtra(IMG_MANGA, 1)

        tvName.text = dataManga!!.name
        desc.text = dataManga.description
        imgPhoto.setImageResource(dataManga.photo)
    }
}