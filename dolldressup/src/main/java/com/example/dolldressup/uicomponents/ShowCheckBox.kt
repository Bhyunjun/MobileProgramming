package com.example.dolldressup.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dolldressup.model.ImageData

@Composable
fun ShowCheckBox(imageList: MutableList<ImageData>, modifier: Modifier = Modifier) {
    val half = imageList.size / 2

    val firstRow = imageList.subList(0, half)
    val secondRow = imageList.subList(half, imageList.size)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            firstRow.forEachIndexed { index, imageData ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ClothesCheckBox(imageData.checked) { isChecked ->
                        imageList[index] = imageData.copy(checked = isChecked)
                    }
                    Text(imageData.imgName)
                }
            }
        }

        Column(horizontalAlignment = Alignment.Start) {
            secondRow.forEachIndexed { index, imageData ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ClothesCheckBox(imageData.checked) { isChecked ->
                        imageList[half + index] = imageData.copy(checked = isChecked)
                    }
                    Text(imageData.imgName)
                }
            }
        }
    }
}
