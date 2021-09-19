package com.project.grubbrr.ui.screensaver

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.project.grubbrr.R
import com.project.grubbrr.data.AppDatabase
import com.project.grubbrr.ui.BaseNewActivity
import com.project.grubbrr.ui.categoryitem.CategoryItemActivity


class ScreenSaverActivity : BaseNewActivity() {

    private var db: AppDatabase? = null
    private var ivScreenSaver: ImageView? = null
    private var screenMoved: Boolean?= false
    private var countDownTimer: CountDownTimer?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screensaver)
        db = AppDatabase.invoke(this)

        ivScreenSaver = findViewById(R.id.ivScreenSaver)

        db!!.screenSaverMastersDao.getAllData().observe(this, Observer { user ->
            try {
                var i = 0
                countDownTimer = object : CountDownTimer(8000, 3000) {
                    override fun onTick(millisUntilFinished: Long) {
                        if (screenMoved!!) {
                            countDownTimer?.cancel()
                        }
                    }
                    override fun onFinish() {
                        Glide.with(this@ScreenSaverActivity).load(user.get(i).ImagePath)
                            .into(ivScreenSaver!!)
                        i++
                        if (i == user.size - 1) i = 0
                        start()
                    }
                }.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })

        ivScreenSaver!!.setOnClickListener {
            screenMoved = true
            countDownTimer?.cancel()
            Intent(this, CategoryItemActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

    }
}
