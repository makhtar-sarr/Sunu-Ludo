package com.example.sunuludo.views

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.R
import com.example.sunuludo.databinding.ActivityGameOfflineBinding
import com.example.sunuludo.models.Game

class GameOfflineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameOfflineBinding
    val EXTRA_MESSAGE = "com.example.android.sunuludo.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_offline)
        val intentGameOfflineActivity = intent
        val game = intentGameOfflineActivity.getSerializableExtra(EXTRA_MESSAGE) as Game

        binding.greenPlayer.text = game.playerGreen
        binding.yellowPlayer.text = game.playerYellow
        binding.redPlayer.text = game.playerRed
        binding.bluePlayer.text = game.playerBlue

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}