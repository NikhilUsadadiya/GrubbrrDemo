@file:Suppress("DEPRECATION")

package com.project.grubbrr.ui

import android.app.Activity
import android.app.ProgressDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity


open class BaseNewActivity : AppCompatActivity() {

    companion object {

        var dialog: ProgressDialog? = null

        fun ShowProgressDialog(activity: Activity, message: String) {
            if (dialog != null) {
                dialog!!.dismiss()
            }
            try {
                dialog = ProgressDialog(activity)
                dialog!!.setMessage(message)
                dialog!!.setCancelable(false)
                dialog!!.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun ShowProgressDialogWithoutText(activity: Activity) {
            if (dialog != null) {
                dialog!!.dismiss()
            }
            try {
                dialog = ProgressDialog(activity)
                dialog!!.setCancelable(false)
                if (Build.VERSION.SDK_INT >= 28) {
                    dialog!!.cancel()
                }
                dialog!!.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun hideProgressDialog() {
            if (dialog != null && dialog!!.isShowing)
                dialog!!.dismiss()
        }
    }

}
