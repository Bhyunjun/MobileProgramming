package com.example.broadcast

import android.app.ComponentCaller
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.broadcast.ui.theme.MobileProgrammingmainTheme


class MainActivity : ComponentActivity() {


    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    fun handleIntent(intent: Intent?){


        val msgSender = intent?.getStringExtra("msgSender")
        val msgBody = intent?.getStringExtra("msgBody")
        setContent {
            MobileProgrammingmainTheme {
                MainScreen(msgSender, msgBody)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileProgrammingmainTheme {
        Greeting("Android")
    }
}


/*
    *  val powerBR = PowerBR()
    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        this.registerReceiver(powerBR, intentFilter)

    }

    override fun onStop() {
        this.unregisterReceiver(powerBR)
        super.onStop()
    }
    * */