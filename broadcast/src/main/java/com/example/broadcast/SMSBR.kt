package com.example.broadcast

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SMSBR : BroadcastReceiver () {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            val msg = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            val msgSender = msg[0].originatingAddress
            val msgBody = msg.joinToString(separator = ""){it.messageBody}
            Log.i("mag", "$msgSender : $msgBody")

            val newIntent = Intent(context, MainActivity::class.java)
            newIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            newIntent.putExtra("msgSender", msgSender)
            newIntent.putExtra("msgBody", msgBody)
            val pendingIntent = PendingIntent.getActivity(
                context, 100, newIntent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
            context?.let {          //context가 널일 때
                makeNotification(context, msgSender!!, pendingIntent)
            }

        }
    }
}