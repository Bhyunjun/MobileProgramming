package com.example.eweek06a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek06a.model.ButtonType
import com.example.eweek06a.uiexamples.ScrollToTopButton
import com.example.eweek06a.viewmodel.ImageViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(modifier: Modifier = Modifier, imageViewModel: ImageViewModel = viewModel()) {

    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    val scrollState = rememberScrollState()
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        LazyColumn(
            state = state,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(items = imageList) { index, items ->
                when (items.buttonType) {
                    ButtonType.ICON -> {
                        ImageWithButton(image = items.imageUri) {
                            ButtonWithIcon(likes = items.likes) {
                                imageList[index] = items.copy(likes = items.likes + 1)
                            }
                        }
                    }

                    ButtonType.BADGE -> {
                        ImageWithButton(image = items.imageUri) {
                            ButtonWithBadge(likes = items.likes) {
                                imageList[index] = items.copy(likes = items.likes + 1)
                            }
                        }
                    }

                    ButtonType.EMOJI -> {
                        ImageWithButton(image = items.imageUri) {
                            ButtonWithEmoji(
                                likes = items.likes,
                                dislikes = items.dislikes,
                                onClickLikes = {
                                    imageList[index] = items.copy(likes = items.likes + 1)
                                },
                                onClickDisLikes = {
                                    imageList[index] = items.copy(dislikes = items.dislikes + 1)
                                }
                            )
                        }
                    }
                }
            }
        }
        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton{
                scope.launch {
                    state.scrollToItem(0)
                }
            }

        }

    } else {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
        }
    }
}