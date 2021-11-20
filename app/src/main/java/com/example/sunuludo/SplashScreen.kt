package com.example.sunuludo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val backgroundImage: ImageView = findViewById(R.id.SplashScreenImage)
        val slideTopAnimation = AnimationUtils.loadAnimation(this, R.anim.top_slider)
        backgroundImage.startAnimation(slideTopAnimation)

        val titleTextView: TextView = findViewById(R.id.title_textView)
        val slideSideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slider)
        titleTextView.startAnimation(slideSideAnimation)

        val bgHome: ImageView = findViewById(R.id.bg_home)
        val slideTopBgHome = AnimationUtils.loadAnimation(this, R.anim.top_slider)
        bgHome.startAnimation(slideTopBgHome)

        Handler().postDelayed({
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish()
        }, 5000)
    }
}