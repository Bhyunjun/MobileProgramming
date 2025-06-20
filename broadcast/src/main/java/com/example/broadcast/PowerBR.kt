package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Intent
import android.widget.Toast
import android.content.Context



class PowerBR : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action==Intent.ACTION_POWER_CONNECTED){
            Toast.makeText(context, "전원연결", Toast.LENGTH_SHORT).show()
        }else if(intent?.action==Intent.ACTION_POWER_DISCONNECTED) {
            Toast.makeText(context, "전원연결 해제", Toast.LENGTH_SHORT).show()
        }
    }

}

/*
* class PowerBR: BroadcastReceiver() {
    override fun onReceive (context : context?,intent : Intetnt?){
        if (intent?.action == Intent.ACTION_POWER_CONNECTED) {
            Toast.makeText(context, "전원연결", Toast.LENGTH_SHORT).show()
        }else if (intent?.action == Intent.ACTION_POWER_CONNECTED) {
            Toast.makeText(context, "전원연결해제", Toast.LENGTH_SHORT).show()
    }
}
    }
*
*
* */
