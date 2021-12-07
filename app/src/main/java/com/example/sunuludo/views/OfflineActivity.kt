package com.example.sunuludo.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.R
import com.example.sunuludo.databinding.ActivityOfflineBinding
import com.example.sunuludo.models.Game


class OfflineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOfflineBinding
    val EXTRA_MESSAGE = "com.example.android.sunuludo.extra.MESSAGE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_offline)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding.startButton.setOnClickListener {
            val intentGameOfflineActivity = Intent(this, GameOfflineActivity::class.java)
            val game = Game (
                binding.greenNameEditText.text.toString(),
                binding.yellowNameEditText.text.toString(),
                binding.redNameEditText.text.toString(),
                binding.blueNameEditText.text.toString()
                )
            intentGameOfflineActivity.putExtra(EXTRA_MESSAGE, game)
            startActivity(intentGameOfflineActivity)
        }
    }
}