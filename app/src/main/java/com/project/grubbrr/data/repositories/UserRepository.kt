package com.dev.mvvmsampleapp.data.repositories

import android.util.Log
import com.dev.mvvmsampleapp.data.network.MyApi
import com.dev.mvvmsampleapp.data.network.SafeApiRequest
import com.dev.mvvmsampleapp.data.network.responses.AuthResponse


class UserRepository (private val api: MyApi
/*private val db: AppDatabase*/
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String,
                          AppVersion: String,
                          DeviceType: String,
                          DeviceID: String,
                          ModuleID: String,
                          FCMID: String) : AuthResponse {
        return apiRequest {
            Log.e("UserRepository", "::>>")
            api.userLogin(email, password, AppVersion, DeviceType, DeviceID, ModuleID, FCMID)
        }
    }


}