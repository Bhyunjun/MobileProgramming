package com.example.dolldressup.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dolldressup.model.ImageData
import com.example.dolldressup.model.ImageListFactory

class ImageViewModel: ViewModel() {
    private val _imageList = ImageListFactory.makeImageList()

    val imageList: MutableList<ImageData>
        get() = _imageList
}