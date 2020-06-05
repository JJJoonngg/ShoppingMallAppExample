package com.jjjoonngg.parayo.fcm

import com.google.firebase.messaging.FirebaseMessagingService
import com.jjjoonngg.parayo.api.ParayoApi
import com.jjjoonngg.parayo.common.Prefs
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.warn

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
                    error(exception.message ?: "토큰 업데티으 실패", exception)
                }
            }
        }
    }
}