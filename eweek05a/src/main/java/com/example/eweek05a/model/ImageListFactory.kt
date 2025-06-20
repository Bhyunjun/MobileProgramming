package com.example.eweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.eweek05a.R

object ImageListFactory {
    fun makeListImage() = mutableStateListOf(
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.EMOJI,
            likes = 100,
            dislikes = 10
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.ICON,
            likes = 100,
            dislikes = 10
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.BADGE,
            likes = 100
        )
    )
}