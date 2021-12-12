package com.example.sunuludo.views

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.R
import com.example.sunuludo.databinding.ActivityGameOfflineBinding

class GameOfflineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameOfflineBinding
    val EXTRA_MESSAGE = "com.example.android.sunuludo.extra.MESSAGE"
    var height = 0
    var width:Int = 0
    var top:Int = 0
    var bottom:Int = 0
    var d:Int = 0
    var n:Int = 0
    var PlayerNo:Int = 0
    var x1 = 1
    var x2:Int = 1
    var x3:Int = 1
    var x4:Int = 1
    var x5:Int = 14
    var x6:Int = 14
    var x7:Int = 14
    var x8:Int = 14
    var x9:Int = 27
    var x10:Int = 27
    var x11:Int = 27
    var x12:Int = 27
    var x13:Int = 40
    var x14:Int = 40
    var x15:Int = 40
    var x16:Int = 40
    private lateinit var boxDiceGreen: ImageView
    private lateinit var boxDiceYellow: ImageView
    private lateinit var boxDiceRed: ImageView
    private lateinit var boxDiceBlue: ImageView
    private lateinit var diceGreen: ImageView
    private lateinit var diceYellow: ImageView
    private lateinit var diceRed: ImageView
    private lateinit var diceBlue: ImageView
    private lateinit var chipGreen1: ImageView
    private lateinit var chipGreen2: ImageView
    private lateinit var chipGreen3: ImageView
    private lateinit var chipGreen4: ImageView
    private lateinit var chipYellow1: ImageView
    private lateinit var chipYellow2: ImageView
    private lateinit var chipYellow3: ImageView
    private lateinit var chipYellow4: ImageView
    private lateinit var chipRed1: ImageView
    private lateinit var chipRed2: ImageView
    private lateinit var chipRed3: ImageView
    private lateinit var chipRed4: ImageView
    private lateinit var chipBlue1: ImageView
    private lateinit var chipBlue2: ImageView
    private lateinit var chipBlue3: ImageView
    private lateinit var chipBlue4: ImageView
    private lateinit var greenPlayerName: CardView
    private lateinit var yellowPlayerName: CardView
    private lateinit var redPlayerName: CardView
    private lateinit var bluePlayerName: CardView
    private lateinit var ludoBoard: ImageView

    var green1:Int = 0
    var green2:Int = 0
    var green3:Int = 0
    var green4:Int = 0
    var yellow1:Int = 0
    var yellow2:Int = 0
    var yellow3:Int = 0
    var yellow4:Int = 0
    var red1:Int = 0
    var red2:Int = 0
    var red3:Int = 0
    var red4:Int = 0
    var blue1:Int = 0
    var blue2:Int = 0
    var blue3:Int = 0
    var blue4:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_offline)
//        val intentGameOfflineActivity = intent
//        val game = intentGameOfflineActivity.getSerializableExtra(EXTRA_MESSAGE) as Game

//        binding.greenPlayer.text = game.playerGreen
//        binding.yellowPlayer.text = game.playerYellow
//        binding.redPlayer.text = game.playerRed
//        binding.bluePlayer.text = game.playerBlue

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        ludoBoard = binding.ludoBoard
        assignItems()
        fillDice(diceGreen, boxDiceGreen)
        fillDice(diceBlue, boxDiceBlue)
        fillDice(diceYellow, boxDiceYellow)
        fillDice(diceRed, boxDiceRed)
        fillPlayerName(greenPlayerName)
        fillPlayerName(yellowPlayerName)
        fillPlayerName(redPlayerName)
        fillPlayerName(bluePlayerName)
        fillGreen(chipGreen1)
        fillGreen(chipGreen2)
        fillGreen(chipGreen3)
        fillGreen(chipGreen4)
        fillYellow(chipYellow1)
        fillYellow(chipYellow2)
        fillYellow(chipYellow3)
        fillYellow(chipYellow4)
        fillRed(chipRed1)
        fillRed(chipRed2)
        fillRed(chipRed3)
        fillRed(chipRed4)
        fillBlue(chipBlue1)
        fillBlue(chipBlue2)
        fillBlue(chipBlue3)
        fillBlue(chipBlue4)

        rollDice(binding.diceGreen)
//        binding.diceYellow.visibility = INVISIBLE
//        binding.diceRed.visibility = INVISIBLE
//        binding.diceBlue.visibility = INVISIBLE
    }

    private fun fillDice(dice: ImageView, diceBox: ImageView) {
//        dice.getLayoutParams().height = 3 * d
//        dice.getLayoutParams().width = 3 * d
//        val mParams = dice.getLayoutParams() as RelativeLayout.LayoutParams
//        mParams.leftMargin = 6 * d
//        mParams.topMargin = width + 5 * d //top + 6 * d
//        dice.setLayoutParams(mParams)
        when (diceBox) {
            binding.boxDiceGreen -> {
                val mParamsGreenBox = boxDiceGreen.layoutParams as RelativeLayout.LayoutParams
                mParamsGreenBox.leftMargin = 0
                mParamsGreenBox.topMargin = width + 5 * d
                boxDiceGreen.layoutParams = mParamsGreenBox
            }
            binding.boxDiceBlue -> {
                val mParamsBlueBox = boxDiceBlue.layoutParams as RelativeLayout.LayoutParams
                mParamsBlueBox.leftMargin = 12 * d + 15
                mParamsBlueBox.topMargin = width + 5 * d
                boxDiceBlue.layoutParams = mParamsBlueBox
            }
            binding.boxDiceYellow -> {
                val mParamsYellowBox = boxDiceYellow.layoutParams as RelativeLayout.LayoutParams
                mParamsYellowBox.leftMargin = 0
                mParamsYellowBox.topMargin = width - 13 * d + 5
                boxDiceYellow.layoutParams = mParamsYellowBox
            }
            binding.boxDiceRed -> {
                val mParamsRedBox = boxDiceRed.layoutParams as RelativeLayout.LayoutParams
                mParamsRedBox.leftMargin = 12 * d + 15
                mParamsRedBox.topMargin = width - 13 * d + 5
                boxDiceRed.layoutParams = mParamsRedBox
            }
        }

        when (dice) {
            binding.diceGreen -> {
                val mParamsGreen = diceGreen.layoutParams as RelativeLayout.LayoutParams
                mParamsGreen.leftMargin = 15
                mParamsGreen.topMargin = width + 5 * d + 15
                diceGreen.layoutParams = mParamsGreen
            }
            binding.diceBlue -> {
                val mParamsBlue = diceBlue.layoutParams as RelativeLayout.LayoutParams
                mParamsBlue.leftMargin = 12 * d + 30
                mParamsBlue.topMargin = width + 5 * d + 15
                diceBlue.layoutParams = mParamsBlue
            }
            binding.diceYellow -> {
                val mParamsYellow = diceYellow.layoutParams as RelativeLayout.LayoutParams
                mParamsYellow.leftMargin = 15
                mParamsYellow.topMargin = width - 13 * d + 20
                diceYellow.layoutParams = mParamsYellow
            }
            binding.diceRed -> {
                val mParamsRed = diceRed.layoutParams as RelativeLayout.LayoutParams
                mParamsRed.leftMargin = 12 * d + 30
                mParamsRed.topMargin = width - 13 * d + 20
                diceRed.layoutParams = mParamsRed
            }
        }
    }

    private fun fillPlayerName(playerName: CardView) {
        when(playerName) {
            binding.greenPlayerName -> {
                val mParamsPlayerGreen = greenPlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerGreen.leftMargin = 90
                mParamsPlayerGreen.topMargin = width + 5 * d + 15
                greenPlayerName.layoutParams = mParamsPlayerGreen
            }
            binding.yellowPlayerName -> {
                val mParamsPlayerYellow = yellowPlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerYellow.leftMargin = 90
                mParamsPlayerYellow.topMargin = width - 13 * d + 20
                yellowPlayerName.layoutParams = mParamsPlayerYellow
            }
            binding.redPlayerName -> {
                val mParamsPlayerRed = redPlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerRed.leftMargin = 6 * d
                mParamsPlayerRed.topMargin = width - 13 * d + 20
                redPlayerName.layoutParams = mParamsPlayerRed
            }
            binding.bluePlayerName -> {
                val mParamsPlayerBlue = bluePlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerBlue.leftMargin = 6 * d
                mParamsPlayerBlue.topMargin = width + 5 * d + 15
                bluePlayerName.layoutParams = mParamsPlayerBlue
            }
        }
    }

    private fun fillGreen(chipGreen: ImageView) {
        when (chipGreen) {
            binding.chipGreen1 -> {
                chipGreen1.layoutParams.height = d
                chipGreen1.layoutParams.width = d
                val mParams1 = chipGreen1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 3 * d / 2
                mParams1.topMargin = 9 * d + top + 3 * d / 2
                chipGreen1.layoutParams = mParams1
                green1 = 0
                x13 = 40
            }
            binding.chipGreen2 -> {
                chipGreen2.layoutParams.height = d
                chipGreen2.layoutParams.width = d
                val mParams2 = chipGreen2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 2 * d + 3 * d / 2
                mParams2.topMargin = 9 * d + top + 3 * d / 2
                chipGreen2.layoutParams = mParams2
                green2 = 0
                x14 = 40
            }
            binding.chipGreen3 -> {
                chipGreen3.layoutParams.height = d
                chipGreen3.layoutParams.width = d
                val mParams3 = chipGreen3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 3 * d / 2
                mParams3.topMargin = 11 * d + top + 3 * d / 2
                chipGreen3.layoutParams = mParams3
                green3 = 0
                x15 = 40
            }
            binding.chipGreen4 -> {
                chipGreen4.layoutParams.height = d
                chipGreen4.layoutParams.width = d
                val mParams4 = chipGreen4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 2 * d + 3 * d / 2
                mParams4.topMargin = 11 * d + top + 3 * d / 2
                chipGreen4.layoutParams = mParams4
                green4 = 0
                x16 = 40
            }
        }
    }

    private fun assignItems() {
        height = resources.displayMetrics.heightPixels
        width = resources.displayMetrics.widthPixels
        top = (height - width) / 2
        bottom = top + width / 2
        d = width / 15
        boxDiceGreen = binding.boxDiceGreen
        boxDiceYellow = binding.boxDiceYellow
        boxDiceRed = binding.boxDiceRed
        boxDiceBlue = binding.boxDiceBlue
        diceGreen = binding.diceGreen
        diceYellow = binding.diceYellow
        diceRed = binding.diceRed
        diceBlue = binding.diceBlue
        greenPlayerName = binding.greenPlayerName
        yellowPlayerName = binding.yellowPlayerName
        redPlayerName = binding.redPlayerName
        bluePlayerName = binding.bluePlayerName
        chipGreen1 = binding.chipGreen1
        chipGreen2 = binding.chipGreen2
        chipGreen3 = binding.chipGreen3
        chipGreen4 = binding.chipGreen4
        chipYellow1 = binding.chipYellow1
        chipYellow2 = binding.chipYellow2
        chipYellow3 = binding.chipYellow3
        chipYellow4 = binding.chipYellow4
        chipRed1 = binding.chipRed1
        chipRed2 = binding.chipRed2
        chipRed3 = binding.chipRed3
        chipRed4 = binding.chipRed4
        chipBlue1 = binding.chipBlue1
        chipBlue2 = binding.chipBlue2
        chipBlue3 = binding.chipBlue3
        chipBlue4 = binding.chipBlue4
    }

    private fun fillYellow(chipYellow: ImageView) {
        when (chipYellow) {
            binding.chipYellow1 -> {
                chipYellow1.layoutParams.height = d
                chipYellow1.layoutParams.width = d
                val mParams1 = chipYellow1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 3 * d / 2
                mParams1.topMargin = top + 3 * d / 2
                chipYellow1.layoutParams = mParams1
                yellow1 = 0
                x1 = 1
            }
            binding.chipYellow2 -> {
                chipYellow2.layoutParams.height = d
                chipYellow2.layoutParams.width = d
                val mParams2 = chipYellow2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 2 * d + 3 * d / 2
                mParams2.topMargin = top + 3 * d / 2
                chipYellow2.layoutParams = mParams2
                yellow2 = 0
                x2 = 1
            }
            binding.chipYellow3 -> {
                chipYellow3.layoutParams.height = d
                chipYellow3.layoutParams.width = d
                val mParams3 = chipYellow3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 3 * d / 2
                mParams3.topMargin = 2 * d + top + 3 * d / 2
                chipYellow3.layoutParams = mParams3
                yellow3 = 0
                x3 = 1
            }
            binding.chipYellow4 -> {
                chipYellow4.layoutParams.height = d
                chipYellow4.layoutParams.width = d
                val mParams4 = chipYellow4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 2 * d + 3 * d / 2
                mParams4.topMargin = 2 * d + top + 3 * d / 2
                chipYellow4.layoutParams = mParams4
                yellow4 = 0
                x4 = 1
            }
        }
    }

    private fun fillRed(chipRed: ImageView) {
        when (chipRed) {
            binding.chipRed1 -> {
                chipRed1.layoutParams.height = d
                chipRed1.layoutParams.width = d
                val mParams1 = chipRed1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 9 * d + 3 * d / 2
                mParams1.topMargin = top + 3 * d / 2
                chipRed1.layoutParams = mParams1
                red1 = 0
                x5 = 14
            }
            binding.chipRed2 -> {
                chipRed2.layoutParams.height = d
                chipRed2.layoutParams.width = d
                val mParams2 = chipRed2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 11 * d + 3 * d / 2
                mParams2.topMargin = top + 3 * d / 2
                chipRed2.layoutParams = mParams2
                red2 = 0
                x6 = 14
            }
            binding.chipRed3 -> {
                chipRed3.layoutParams.height = d
                chipRed3.layoutParams.width = d
                val mParams3 = chipRed3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 9 * d + 3 * d / 2
                mParams3.topMargin = 2 * d + top + 3 * d / 2
                chipRed3.layoutParams = mParams3
                red3 = 0
                x7 = 14
            }
            binding.chipRed4 -> {
                chipRed4.layoutParams.height = d
                chipRed4.layoutParams.width = d
                val mParams4 = chipRed4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 11 * d + 3 * d / 2
                mParams4.topMargin = 2 * d + top + 3 * d / 2
                chipRed4.layoutParams = mParams4
                red4 = 0
                x8 = 14
            }
        }
    }

    private fun fillBlue(chipBlue: ImageView) {
        when (chipBlue) {
            binding.chipBlue1 -> {
                chipBlue1.layoutParams.height = d
                chipBlue1.layoutParams.width = d
                val mParams1 = chipBlue1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 9 * d + 3 * d / 2
                mParams1.topMargin = 9 * d + top + 3 * d / 2
                chipBlue1.layoutParams = mParams1
                blue1 = 0
                x9 = 27
            }
            binding.chipBlue2 -> {
                chipBlue2.layoutParams.height = d
                chipBlue2.layoutParams.width = d
                val mParams2 = chipBlue2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 11 * d + 3 * d / 2
                mParams2.topMargin = 9 * d + top + 3 * d / 2
                chipBlue2.layoutParams = mParams2
                blue2 = 0
                x10 = 27
            }
            binding.chipBlue3 -> {
                chipBlue3.layoutParams.height = d
                chipBlue3.layoutParams.width = d
                val mParams3 = chipBlue3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 9 * d + 3 * d / 2
                mParams3.topMargin = 11 * d + top + 3 * d / 2
                chipBlue3.layoutParams = mParams3
                blue3 = 0
                x11 = 27
            }
            binding.chipBlue4 -> {
                chipBlue4.layoutParams.height = d
                chipBlue4.layoutParams.width = d
                val mParams4 = chipBlue4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 11 * d + 3 * d / 2
                mParams4.topMargin = 11 * d + top + 3 * d / 2
                chipBlue4.layoutParams = mParams4
                blue4 = 0
                x12 = 27
            }
        }
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