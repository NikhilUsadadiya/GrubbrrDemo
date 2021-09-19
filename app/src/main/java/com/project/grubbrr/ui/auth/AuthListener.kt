package com.dev.mvvmsampleapp.ui.auth

import com.dev.mvvmsampleapp.data.network.responses.AuthResponse

interface AuthListener {

    fun onStarted()
    suspend fun onSuccess(user: AuthResponse)
    fun onFailure(message: String)

}