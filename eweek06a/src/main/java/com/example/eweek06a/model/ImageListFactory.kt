package com.example.eweek06a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.eweek06a.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.ICON,
            likes = 50
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.BADGE,
            likes = 100
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 70,
            dislikes = 5
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.BADGE,
            likes = 50
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.ICON,
            likes = 40
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.ICON,
            likes = 40
        ),
    )
}