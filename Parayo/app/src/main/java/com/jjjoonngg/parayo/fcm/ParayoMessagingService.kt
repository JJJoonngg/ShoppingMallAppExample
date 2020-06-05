package com.jjjoonngg.parayo.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.jjjoonngg.parayo.R
import com.jjjoonngg.parayo.api.ParayoApi
import com.jjjoonngg.parayo.common.Prefs
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.*

class ParayoMessagingService : FirebaseMessagingService(), AnkoLogger {

    override fun onNewToken(fcmToken: String) {
        Prefs.fcmToken = fcmToken
        if (!Prefs.token.isNullOrEmpty() && fcmToken != null) {
            runBlocking {
                try {
                    val response = ParayoApi.instance.updateFcmToken(fcmToken)
                    if (!response.success) {
                        warn(response.message ?: "토큰 업데이트 실패")
                    }
                } catch (exception: Exception) {
                    error(exception.message ?: "토큰 업데이트 실패", exception)
                }
            }
        }
    }

    override fun onMessageReceived(message: RemoteMessage) {
        message?.data?.let { data ->
            debug(data)
            createNotificationChannelIfNeeded()

            val bulider = NotificationCompat
                .Builder(this, "channel.parayo.default")
                .setContentTitle(data["title"])
                .setContentText(data["content"])
                .setSmallIcon(R.drawable.ic_logo)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(this)) {
                notify(NotificationId.generate(), bulider.build())
            }
        }
    }

    private fun createNotificationChannelIfNeeded() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "channel.parayo.default",
                "기본 알림",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "기본 알림"
            notificationManager.createNotificationChannel(channel)
        }
    }
}