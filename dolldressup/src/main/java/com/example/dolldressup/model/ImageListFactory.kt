package com.example.dolldressup.model

import androidx.compose.runtime.mutableStateListOf
import com.example.dolldressup.R

object ImageListFactory {
    fun makeImageList()= mutableStateListOf(
        //ImageData(imgUri = R.drawable.body, checked = true, imgName = "body"),
        ImageData(imgUri = R.drawable.eyes, checked = true, imgName = "eyes"),
        ImageData(imgUri = R.drawable.eyebrows, checked = true, imgName = "eyebrows"),
        ImageData(imgUri = R.drawable.ears, checked = true, imgName = "ears"),
        ImageData(imgUri = R.drawable.glasses, checked = true, imgName = "glasses"),
        ImageData(imgUri = R.drawable.mouth, checked = true, imgName = "mouth"),
        ImageData(imgUri = R.drawable.nose, checked = true, imgName = "nose"),
        ImageData(imgUri = R.drawable.mustache, checked = true, imgName = "mustache"),
        ImageData(imgUri = R.drawable.hat, checked = true, imgName = "hat"),
        ImageData(imgUri = R.drawable.arms, checked = true, imgName = "arms"),
        ImageData(imgUri = R.drawable.shoes, checked = true, imgName = "shoes"),
    )
}