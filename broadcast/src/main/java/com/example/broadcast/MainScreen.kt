package com.example.broadcast

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen (msgSender:String?, msgBody: String?) {

    val permissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.RECEIVE_SMS,
            android.Manifest.permission.POST_NOTIFICATIONS
        )
    )

    LaunchedEffect(Unit) {
        permissions.launchMultiplePermissionRequest()
    }

    var msg by remember {
        mutableStateOf("")
    }
    LaunchedEffect(msgBody){
        if(permissions.permissions[0].status.isGranted && msgBody !=null)
            msg = msgBody
    }
    Column {
        Text(text = msg)
    }
}





   /* var msg by remember {
       mutableStateOf("")
    }

    MyBR(Intent.ACTION_POWER_CONNECTED) {
        msg = "전원연결"
    }

    MyBR(Intent.ACTION_POWER_DISCONNECTED) {
        msg = "전원연결 해제"
    }

    Column {
        Text(text = msg)
    }*/
