package com.example.eweek05a.model

sealed class ImageUri {     // 파일 내부에서만 상속 가능
    data class ResImage(val resID: Int) : ImageUri()
    data class WebImage(val webUrl: String) : ImageUri()

}