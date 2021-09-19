package com.dev.mvvmsampleapp.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.dev.mvvmsampleapp.data.repositories.UserRepository
import com.dev.mvvmsampleapp.utils.ApiException
import com.dev.mvvmsampleapp.utils.Coroutines
import com.dev.mvvmsampleapp.utils.NoIntenetConnection
import com.project.grubbrr.utils.Constants

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var name: String? = null
    var email: String? = "grubbrrcafe@gmail.com"
    var password: String? = "54176"
    var authListener: AuthListener? = null


    fun onLoginButtonClicked(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("invalid or empty")

            return
        }

        Coroutines.main {
            try {
                Log.e("AuthViewModel", "::>>")
                val authResponse = repository.userLogin(
                    email!!,
                    password!!,
                    Constants.APPVERSION,
                    Constants.DEVICE_TYPE,
                    Constants.DEVICE_ID,
                    Constants.MODULE_ID,
                    Constants.FCMID
                )

                authResponse.let {
                    authListener?.onSuccess(authResponse)
                    return@main
                }

                authListener?.onFailure(Constants.NO_DATA_FOUND)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoIntenetConnection) {
                authListener?.onFailure(e.message!!)
            }
        }

    }


}