package com.example.dolldressup.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dolldressup.R
import com.example.dolldressup.model.ImageData


@Composable
fun DollScreen(modifier: Modifier = Modifier, imageList: MutableList<ImageData>) {
    Box(
        modifier = modifier.padding(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.body),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        imageList.forEachIndexed { index, imageData ->
            if (imageData.checked) {
                Image(
                    painter = painterResource(id = imageData.imgUri),
                    contentDescription = imageData.imgName,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
    ShowCheckBox(imageList)
}