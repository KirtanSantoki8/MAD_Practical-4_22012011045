package com.devkt.mad_practical_4_22012011045

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent != null && context != null) {
            val str1 = intent.getStringExtra("Service1")
            Log.d("AlarmBroadcastReceiver", "str1 value: $str1")
            if (str1 == "Start" || str1 == "Stop") {
                val intentService = Intent(context, AlarmService::class.java)
                intentService.putExtra("Service1", intent.getStringExtra("Service1"))
                if (str1 == "Start") {
                    context.startService(intentService)
                } else if (str1 == "Stop") {
                    context.stopService(intentService)
                }
            }
        }
    }
}