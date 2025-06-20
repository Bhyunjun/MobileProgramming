package com.example.eweek06a.model

data class ImageData(
    val imageUri: ImageUri,
    val buttonType: ButtonType = ButtonType.ICON,
    var likes:Int = 0,
    var dislikes:Int = 0
)
