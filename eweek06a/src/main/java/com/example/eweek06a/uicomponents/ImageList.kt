package com.example.eweek06a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eweek06a.model.ButtonType
import com.example.eweek06a.model.ImageData

@Composable
fun ImageList(modifier: Modifier = Modifier, imageList: MutableList<ImageData>) {
    imageList.forEachIndexed { index, imageData ->
        when(imageData.buttonType){
            ButtonType.ICON -> {
                ImageWithButton(image = imageData.imageUri) {
                    ButtonWithIcon(likes = imageData.likes) {
                        imageList[index] = imageData.copy(likes = imageData.likes + 1)
                    }
                }
            }
            ButtonType.BADGE -> {
                ImageWithButton(image = imageData.imageUri) {
                    ButtonWithBadge(likes = imageData.likes) {
                        imageList[index] = imageData.copy(likes = imageData.likes + 1)
                    }
                }
            }
            ButtonType.EMOJI -> {
                ImageWithButton(image = imageData.imageUri) {
                    ButtonWithEmoji(
                        likes = imageData.likes,
                        dislikes = imageData.dislikes,
                        onClickLikes = {
                            imageList[index] = imageData.copy(likes = imageData.likes + 1)
                        },
                        onClickDisLikes = {
                            imageList[index] = imageData.copy(dislikes = imageData.dislikes + 1)
                        }
                    )
                }
            }
        }
    }
}