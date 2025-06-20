package com.example.eweek06a.uiexamples

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun RandomColorButton() {
    val scope = rememberCoroutineScope()    // 코루틴 객체 생성
    var color by remember { mutableStateOf(Color.Red) } // 상태 선언, 바뀔 때 화면 재랜더링
    // scope.launch 실행 불가 이 곳에 선언 되었을 경우 재랜더링 되었을 때마다 코루틴이 생성되기 때문
    Column {
        Button(
            onClick = {
                scope.launch {  // onClick 되었을 때만 코루틴 실행
                    while (true) {
                        delay(500) // suspend 함수
                        color = Color(
                            Random.nextInt(0xFF), // R
                            Random.nextInt(0xFF), // G
                            Random.nextInt(0xFF), // B
                            0xFF // 투명도
                        )
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(color)
        ) {
            Text("Change Color")
        }
    }
}

@Composable
fun RandomColorButton2() {
    val scope = rememberCoroutineScope()
    var color by remember { mutableStateOf(Color.Red) }

    Column {
        Button(
            onClick = {
               val job = scope.launch {
                    while (true) {
                        delay(500)
                        color = Color(
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            0xFF
                        )
                    }
                }

                scope.launch {
                    delay(2000)
                    job.cancel()
                }
            },
            colors = ButtonDefaults.buttonColors(color)
        ) {
            Text("Change Color")
        }
    }
}

@Preview
@Composable
private fun RandomColorButtonPreview() {
    Column {
        RandomColorButton()
        RandomColorButton2()
    }

}