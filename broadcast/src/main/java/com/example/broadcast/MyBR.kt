package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun MyBR(
    brAction:String,
    brEvent:(intent : Intent?) -> Unit      //왜 ?을 빼면 25줄에서 intent가 오류나지?
) {
    val context = LocalContext.current
    DisposableEffect(Unit) {
        val intentFilter = IntentFilter(brAction)
        val br = object:BroadcastReceiver() {
            override fun onReceive(
                context: Context?,
                intent: Intent?)
            {
                brEvent(intent)
            }
        }

        context.registerReceiver(br, intentFilter)
        onDispose {
            context.unregisterReceiver(br)
        }
    }
}