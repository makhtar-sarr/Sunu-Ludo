package com.example.sunuludo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.R
import com.example.sunuludo.databinding.ActivityMainBinding
import com.example.sunuludo.databinding.ActivityOfflineBinding
import com.example.sunuludo.models.Game

class OfflineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOfflineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_offline)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding.oneGame = Game()

        binding.startButton.setOnClickListener {
            val game = Game(
                binding.playerNameGreenOutlinedTextField.toString(),
                binding.playerNameYellowOutlinedTextField.toString(),
                binding.playerNameRedOutlinedTextField.toString(),
                binding.playerNameBlueOutlinedTextField.toString()
            )

            binding.oneGame = game

            intent.putExtra("gameData", game)
            setResult(RESULT_OK, intent)

            val gameIntent = Intent(this, GameOfflineActivity::class.java)
            startActivity(gameIntent)
        }
    }
}