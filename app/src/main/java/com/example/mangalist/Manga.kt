package com.example.mangalist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga(
    val name : String,
    val description : String,
    val photo : Int
) : Parcelable
