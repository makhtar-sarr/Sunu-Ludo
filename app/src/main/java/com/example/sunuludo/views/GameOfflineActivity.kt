package com.example.sunuludo.views

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.R
import com.example.sunuludo.databinding.ActivityGameOfflineBinding
import com.example.sunuludo.models.Game

class GameOfflineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameOfflineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_offline)

        val data = ArrayList<Game>()

        val luncherResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val dataGame: Intent? = result.data
                val game = dataGame?.getSerializableExtra("dataGame") as Game
                data.add(game)
            }
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}