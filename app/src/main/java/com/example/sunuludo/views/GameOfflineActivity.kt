package com.example.sunuludo.views

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.WindowManager
import android.widget.ImageView
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

        rollDice(binding.diceGreen)
        binding.diceYellow.visibility = INVISIBLE
        binding.diceRed.visibility = INVISIBLE
        binding.diceBlue.visibility = INVISIBLE
    }

    private fun rollDice(diceImage: ImageView) {
        // Create new Dice object with 6 sides and roll it.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the image in the layout


        // determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.ic_dice_1_fill_svgrepo_com
            2 -> R.drawable.ic_dice_2_fill_svgrepo_com
            3 -> R.drawable.ic_dice_3_fill_svgrepo_com
            4 -> R.drawable.ic_dice_4_fill_svgrepo_com
            5 -> R.drawable.ic_dice_5_fill_svgrepo_com
            else -> R.drawable.ic_dice_6_fill_svgrepo_com
        }

        // Update the imageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}