package com.example.sunuludo.views

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.R
import com.example.sunuludo.databinding.ActivityGameOfflineBinding

class GameOfflineActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGameOfflineBinding

    //val EXTRA_MESSAGE = "com.example.android.sunuludo.extra.MESSAGE"
    var height = 0
    var width: Int = 0
    var top: Int = 0
    var bottom: Int = 0
    var d: Int = 0
    var n: Int = 0
    var n1: Int = 0
    var n2: Int = 0
    var n3: Int = 0
    var n4: Int = 0
    var red = 0
    var blue: Int = 0
    var green: Int = 0
    var yellow: Int = 0
    var PlayerNo: Int = 0
    var extraN = 0
    var x1 = 1
    var x2: Int = 1
    var x3: Int = 1
    var x4: Int = 1
    var x5: Int = 14
    var x6: Int = 14
    var x7: Int = 14
    var x8: Int = 14
    var x9: Int = 27
    var x10: Int = 27
    var x11: Int = 27
    var x12: Int = 27
    var x13: Int = 40
    var x14: Int = 40
    var x15: Int = 40
    var x16: Int = 40
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

    var green1: Int = 0
    var green2: Int = 0
    var green3: Int = 0
    var green4: Int = 0
    var yellow1: Int = 0
    var yellow2: Int = 0
    var yellow3: Int = 0
    var yellow4: Int = 0
    var red1: Int = 0
    var red2: Int = 0
    var red3: Int = 0
    var red4: Int = 0
    var blue1: Int = 0
    var blue2: Int = 0
    var blue3: Int = 0
    var blue4: Int = 0

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
        startGame()
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
        when (playerName) {
            binding.greenPlayerName -> {
                val mParamsPlayerGreen = greenPlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerGreen.leftMargin = 90
                mParamsPlayerGreen.topMargin = width + 5 * d
                greenPlayerName.layoutParams = mParamsPlayerGreen
            }
            binding.yellowPlayerName -> {
                val mParamsPlayerYellow = yellowPlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerYellow.leftMargin = 90
                mParamsPlayerYellow.topMargin = width - 12 * d + 20
                yellowPlayerName.layoutParams = mParamsPlayerYellow
            }
            binding.redPlayerName -> {
                val mParamsPlayerRed = redPlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerRed.leftMargin = 8 * d + 10
                mParamsPlayerRed.topMargin = width - 12 * d + 20
                redPlayerName.layoutParams = mParamsPlayerRed
            }
            binding.bluePlayerName -> {
                val mParamsPlayerBlue = bluePlayerName.layoutParams as RelativeLayout.LayoutParams
                mParamsPlayerBlue.leftMargin = 8 * d + 10
                mParamsPlayerBlue.topMargin = width + 5 * d
                bluePlayerName.layoutParams = mParamsPlayerBlue
            }
        }
    }

    private fun fillGreen(chipGreen: ImageView) {
        when (chipGreen) {
            binding.chipGreen1 -> {
                chipGreen1.layoutParams.height = d - 5
                chipGreen1.layoutParams.width = d - 5
                val mParams1 = chipGreen1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 3 * d / 2
                mParams1.topMargin = 9 * d + top + 3 * d / 2
                chipGreen1.layoutParams = mParams1
                green1 = 0
                x13 = 40
            }
            binding.chipGreen2 -> {
                chipGreen2.layoutParams.height = d - 5
                chipGreen2.layoutParams.width = d - 5
                val mParams2 = chipGreen2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 2 * d + 3 * d / 2
                mParams2.topMargin = 9 * d + top + 3 * d / 2
                chipGreen2.layoutParams = mParams2
                green2 = 0
                x14 = 40
            }
            binding.chipGreen3 -> {
                chipGreen3.layoutParams.height = d - 5
                chipGreen3.layoutParams.width = d - 5
                val mParams3 = chipGreen3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 3 * d / 2
                mParams3.topMargin = 11 * d + top + 3 * d / 2
                chipGreen3.layoutParams = mParams3
                green3 = 0
                x15 = 40
            }
            binding.chipGreen4 -> {
                chipGreen4.layoutParams.height = d - 5
                chipGreen4.layoutParams.width = d - 5
                val mParams4 = chipGreen4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 2 * d + 3 * d / 2
                mParams4.topMargin = 11 * d + top + 3 * d / 2
                chipGreen4.layoutParams = mParams4
                green4 = 0
                x16 = 40
            }
        }
    }

    private fun fillYellow(chipYellow: ImageView) {
        when (chipYellow) {
            binding.chipYellow1 -> {
                chipYellow1.layoutParams.height = d - 5
                chipYellow1.layoutParams.width = d - 5
                val mParams1 = chipYellow1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 3 * d / 2
                mParams1.topMargin = top + 3 * d / 2
                chipYellow1.layoutParams = mParams1
                yellow1 = 0
                x1 = 1
            }
            binding.chipYellow2 -> {
                chipYellow2.layoutParams.height = d - 5
                chipYellow2.layoutParams.width = d - 5
                val mParams2 = chipYellow2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 2 * d + 3 * d / 2
                mParams2.topMargin = top + 3 * d / 2
                chipYellow2.layoutParams = mParams2
                yellow2 = 0
                x2 = 1
            }
            binding.chipYellow3 -> {
                chipYellow3.layoutParams.height = d - 5
                chipYellow3.layoutParams.width = d - 5
                val mParams3 = chipYellow3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 3 * d / 2
                mParams3.topMargin = 2 * d + top + 3 * d / 2
                chipYellow3.layoutParams = mParams3
                yellow3 = 0
                x3 = 1
            }
            binding.chipYellow4 -> {
                chipYellow4.layoutParams.height = d - 5
                chipYellow4.layoutParams.width = d - 5
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
                chipRed1.layoutParams.height = d - 5
                chipRed1.layoutParams.width = d - 5
                val mParams1 = chipRed1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 9 * d + 3 * d / 2
                mParams1.topMargin = top + 3 * d / 2
                chipRed1.layoutParams = mParams1
                red1 = 0
                x5 = 14
            }
            binding.chipRed2 -> {
                chipRed2.layoutParams.height = d - 5
                chipRed2.layoutParams.width = d - 5
                val mParams2 = chipRed2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 11 * d + 3 * d / 2
                mParams2.topMargin = top + 3 * d / 2
                chipRed2.layoutParams = mParams2
                red2 = 0
                x6 = 14
            }
            binding.chipRed3 -> {
                chipRed3.layoutParams.height = d - 5
                chipRed3.layoutParams.width = d - 5
                val mParams3 = chipRed3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 9 * d + 3 * d / 2
                mParams3.topMargin = 2 * d + top + 3 * d / 2
                chipRed3.layoutParams = mParams3
                red3 = 0
                x7 = 14
            }
            binding.chipRed4 -> {
                chipRed4.layoutParams.height = d - 5
                chipRed4.layoutParams.width = d - 5
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
                chipBlue1.layoutParams.height = d - 5
                chipBlue1.layoutParams.width = d - 5
                val mParams1 = chipBlue1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 9 * d + 3 * d / 2
                mParams1.topMargin = 9 * d + top + 3 * d / 2
                chipBlue1.layoutParams = mParams1
                blue1 = 0
                x9 = 27
            }
            binding.chipBlue2 -> {
                chipBlue2.layoutParams.height = d - 5
                chipBlue2.layoutParams.width = d - 5
                val mParams2 = chipBlue2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 11 * d + 3 * d / 2
                mParams2.topMargin = 9 * d + top + 3 * d / 2
                chipBlue2.layoutParams = mParams2
                blue2 = 0
                x10 = 27
            }
            binding.chipBlue3 -> {
                chipBlue3.layoutParams.height = d - 5
                chipBlue3.layoutParams.width = d - 5
                val mParams3 = chipBlue3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 9 * d + 3 * d / 2
                mParams3.topMargin = 11 * d + top + 3 * d / 2
                chipBlue3.layoutParams = mParams3
                blue3 = 0
                x11 = 27
            }
            binding.chipBlue4 -> {
                chipBlue4.layoutParams.height = d - 5
                chipBlue4.layoutParams.width = d - 5
                val mParams4 = chipBlue4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 11 * d + 3 * d / 2
                mParams4.topMargin = 11 * d + top + 3 * d / 2
                chipBlue4.layoutParams = mParams4
                blue4 = 0
                x12 = 27
            }
        }
    }

    private fun fillOnGreen(chipOnGreen: ImageView) {
        when (chipOnGreen) {
            binding.chipYellow1 -> {
                chipYellow1.layoutParams.height = d - 5
                chipYellow1.layoutParams.width = d - 5
                val mParams1 = chipYellow1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 3 * d / 2
                mParams1.topMargin = top + 14 * d
                chipYellow1.layoutParams = mParams1
                yellow1 = 2
                x1 = 1
            }
            binding.chipYellow2 -> {
                chipYellow2.layoutParams.height = d - 5
                chipYellow2.layoutParams.width = d - 5
                val mParams2 = chipYellow2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 3 * d / 2
                mParams2.topMargin = top + 14 * d
                chipYellow2.layoutParams = mParams2
                yellow2 = 2
                x2 = 1
            }
            binding.chipYellow3 -> {
                chipYellow3.layoutParams.height = d - 5
                chipYellow3.layoutParams.width = d - 5
                val mParams3 = chipYellow3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 3 * d / 2
                mParams3.topMargin = top + 14 * d
                chipYellow3.layoutParams = mParams3
                yellow3 = 2
                x3 = 1
            }
            binding.chipYellow4 -> {
                chipYellow4.layoutParams.height = d - 5
                chipYellow4.layoutParams.width = d - 5
                val mParams4 = chipYellow4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 3 * d / 2
                mParams4.topMargin = top + 14 * d
                chipYellow4.layoutParams = mParams4
                yellow4 = 2
                x4 = 1
            }
            binding.chipRed1 -> {
                chipRed1.layoutParams.height = d - 5
                chipRed1.layoutParams.width = d - 5
                val mParamRed1 = chipRed1.layoutParams as RelativeLayout.LayoutParams
                mParamRed1.leftMargin = 1 * d + 3 * d / 2
                mParamRed1.topMargin = top + 14 * d
                chipRed1.layoutParams = mParamRed1
                red1 = 2
                x5 = 14
            }
            binding.chipRed2 -> {
                chipRed2.layoutParams.height = d - 5
                chipRed2.layoutParams.width = d - 5
                val mParamRed2 = chipRed2.layoutParams as RelativeLayout.LayoutParams
                mParamRed2.leftMargin = 1 * d + 3 * d / 2
                mParamRed2.topMargin = top + 14 * d
                chipRed2.layoutParams = mParamRed2
                red2 = 2
                x6 = 14
            }
            binding.chipRed3 -> {
                chipRed3.layoutParams.height = d - 5
                chipRed3.layoutParams.width = d - 5
                val mParamRed3 = chipRed3.layoutParams as RelativeLayout.LayoutParams
                mParamRed3.leftMargin = 1 * d + 3 * d / 2
                mParamRed3.topMargin = top + 14 * d
                chipRed3.layoutParams = mParamRed3
                red3 = 2
                x7 = 14
            }
            binding.chipRed4 -> {
                chipRed4.layoutParams.height = d - 5
                chipRed4.layoutParams.width = d - 5
                val mParamRed4 = chipRed4.layoutParams as RelativeLayout.LayoutParams
                mParamRed4.leftMargin = 1 * d + 3 * d / 2
                mParamRed4.topMargin = top + 14 * d
                chipRed4.layoutParams = mParamRed4
                red4 = 2
                x8 = 14
            }
            binding.chipBlue1 -> {
                chipBlue1.layoutParams.height = d - 5
                chipBlue1.layoutParams.width = d - 5
                val mParamBlue1 = chipBlue1.layoutParams as RelativeLayout.LayoutParams
                mParamBlue1.leftMargin = 2 * d + 3 * d / 2
                mParamBlue1.topMargin = top + 14 * d
                chipBlue1.layoutParams = mParamBlue1
                blue1 = 2
                x9 = 27
            }
            binding.chipBlue2 -> {
                chipBlue2.layoutParams.height = d - 5
                chipBlue2.layoutParams.width = d - 5
                val mParamBlue2 = chipBlue2.layoutParams as RelativeLayout.LayoutParams
                mParamBlue2.leftMargin = 2 * d + 3 * d / 2
                mParamBlue2.topMargin = top + 14 * d
                chipBlue2.layoutParams = mParamBlue2
                blue2 = 2
                x10 = 27
            }
            binding.chipBlue3 -> {
                chipBlue3.layoutParams.height = d - 5
                chipBlue3.layoutParams.width = d - 5
                val mParamBlue3 = chipBlue3.layoutParams as RelativeLayout.LayoutParams
                mParamBlue3.leftMargin = 2 * d + 3 * d / 2
                mParamBlue3.topMargin = top + 14 * d
                chipBlue3.layoutParams = mParamBlue3
                blue3 = 2
                x11 = 27
            }
            binding.chipBlue4 -> {
                chipBlue4.layoutParams.height = d - 5
                chipBlue4.layoutParams.width = d - 5
                val mParamBlue4 = chipBlue4.layoutParams as RelativeLayout.LayoutParams
                mParamBlue4.leftMargin = 2 * d + 3 * d / 2
                mParamBlue4.topMargin = top + 14 * d
                chipBlue4.layoutParams = mParamBlue4
                blue4 = 2
                x12 = 27
            }
        }
    }

    private fun fillOnYellow(chipOnYellow: ImageView) {
        when (chipOnYellow) {
            binding.chipGreen1 -> {
                chipGreen1.layoutParams.height = d - 5
                chipGreen1.layoutParams.width = d - 5
                val mParams1 = chipGreen1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 0
                mParams1.topMargin = top + 3 * d / 2
                chipGreen1.layoutParams = mParams1
                green1 = 2
                x13 = 40
            }
            binding.chipGreen2 -> {
                chipGreen2.layoutParams.height = d - 5
                chipGreen2.layoutParams.width = d - 5
                val mParams2 = chipGreen2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 0
                mParams2.topMargin = top + 3 * d / 2
                chipGreen2.layoutParams = mParams2
                green2 = 2
                x14 = 40
            }
            binding.chipGreen3 -> {
                chipGreen3.layoutParams.height = d - 5
                chipGreen3.layoutParams.width = d - 5
                val mParams3 = chipGreen3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 0
                mParams3.topMargin = top + 3 * d / 2
                chipGreen3.layoutParams = mParams3
                green3 = 2
                x15 = 40
            }
            binding.chipGreen4 -> {
                chipGreen4.layoutParams.height = d - 5
                chipGreen4.layoutParams.width = d - 5
                val mParams4 = chipGreen4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 0
                mParams4.topMargin = top + 3 * d / 2
                chipGreen4.layoutParams = mParams4
                green4 = 2
                x16 = 40
            }
            binding.chipRed1 -> {
                chipRed1.layoutParams.height = d - 5
                chipRed1.layoutParams.width = d - 5
                val mParamRed1 = chipRed1.layoutParams as RelativeLayout.LayoutParams
                mParamRed1.leftMargin = 0
                mParamRed1.topMargin = top + 5 * d / 2
                chipRed1.layoutParams = mParamRed1
                red1 = 2
                x5 = 14
            }
            binding.chipRed2 -> {
                chipRed2.layoutParams.height = d - 5
                chipRed2.layoutParams.width = d - 5
                val mParamRed2 = chipRed2.layoutParams as RelativeLayout.LayoutParams
                mParamRed2.leftMargin = 0
                mParamRed2.topMargin = top + 5 * d / 2
                chipRed2.layoutParams = mParamRed2
                red2 = 2
                x6 = 14
            }
            binding.chipRed3 -> {
                chipRed3.layoutParams.height = d - 5
                chipRed3.layoutParams.width = d - 5
                val mParamRed3 = chipRed3.layoutParams as RelativeLayout.LayoutParams
                mParamRed3.leftMargin = 0
                mParamRed3.topMargin = top + 5 * d / 2
                chipRed3.layoutParams = mParamRed3
                red3 = 2
                x7 = 14
            }
            binding.chipRed4 -> {
                chipRed4.layoutParams.height = d - 5
                chipRed4.layoutParams.width = d - 5
                val mParamRed4 = chipRed4.layoutParams as RelativeLayout.LayoutParams
                mParamRed4.leftMargin = 0
                mParamRed4.topMargin = top + 5 * d / 2
                chipRed4.layoutParams = mParamRed4
                red4 = 2
                x8 = 14
            }
            binding.chipBlue1 -> {
                chipBlue1.layoutParams.height = d - 5
                chipBlue1.layoutParams.width = d - 5
                val mParamBlue1 = chipBlue1.layoutParams as RelativeLayout.LayoutParams
                mParamBlue1.leftMargin = 0
                mParamBlue1.topMargin = top + 7 * d / 2
                chipBlue1.layoutParams = mParamBlue1
                blue1 = 2
                x9 = 27
            }
            binding.chipBlue2 -> {
                chipBlue2.layoutParams.height = d - 5
                chipBlue2.layoutParams.width = d - 5
                val mParamBlue2 = chipBlue2.layoutParams as RelativeLayout.LayoutParams
                mParamBlue2.leftMargin = 0
                mParamBlue2.topMargin = top + 7 * d / 2
                chipBlue2.layoutParams = mParamBlue2
                blue2 = 2
                x10 = 27
            }
            binding.chipBlue3 -> {
                chipBlue3.layoutParams.height = d - 5
                chipBlue3.layoutParams.width = d - 5
                val mParamBlue3 = chipBlue3.layoutParams as RelativeLayout.LayoutParams
                mParamBlue3.leftMargin = 0
                mParamBlue3.topMargin = top + 7 * d / 2
                chipBlue3.layoutParams = mParamBlue3
                blue3 = 2
                x11 = 27
            }
            binding.chipBlue4 -> {
                chipBlue4.layoutParams.height = d - 5
                chipBlue4.layoutParams.width = d - 5
                val mParamBlue4 = chipBlue4.layoutParams as RelativeLayout.LayoutParams
                mParamBlue4.leftMargin = 0
                mParamBlue4.topMargin = top + 7 * d / 2
                chipBlue4.layoutParams = mParamBlue4
                blue4 = 2
                x12 = 27
            }
        }
    }

    private fun fillOnRed(chipOnRed: ImageView) {
        when (chipOnRed) {
            binding.chipGreen1 -> {
                chipGreen1.layoutParams.height = d - 5
                chipGreen1.layoutParams.width = d - 5
                val mParams1 = chipGreen1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 9 * d + 3 * d / 2
                mParams1.topMargin = top
                chipGreen1.layoutParams = mParams1
                green1 = 2
                x13 = 40
            }
            binding.chipGreen2 -> {
                chipGreen2.layoutParams.height = d - 5
                chipGreen2.layoutParams.width = d - 5
                val mParams2 = chipGreen2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 9 * d + 3 * d / 2
                mParams2.topMargin = top
                chipGreen2.layoutParams = mParams2
                green2 = 2
                x14 = 40
            }
            binding.chipGreen3 -> {
                chipGreen3.layoutParams.height = d - 5
                chipGreen3.layoutParams.width = d - 5
                val mParams3 = chipGreen3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 9 * d + 3 * d / 2
                mParams3.topMargin = top
                chipGreen3.layoutParams = mParams3
                green3 = 2
                x15 = 40
            }
            binding.chipGreen4 -> {
                chipGreen4.layoutParams.height = d - 5
                chipGreen4.layoutParams.width = d - 5
                val mParams4 = chipGreen4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 9 * d + 3 * d / 2
                mParams4.topMargin = top
                chipGreen4.layoutParams = mParams4
                green4 = 2
                x16 = 40
            }
            binding.chipYellow1 -> {
                chipYellow1.layoutParams.height = d - 5
                chipYellow1.layoutParams.width = d - 5
                val mParamYellow1 = chipYellow1.layoutParams as RelativeLayout.LayoutParams
                mParamYellow1.leftMargin = 10 * d + 3 * d / 2
                mParamYellow1.topMargin = top
                chipYellow1.layoutParams = mParamYellow1
                yellow1 = 2
                x1 = 1
            }
            binding.chipYellow2 -> {
                chipYellow2.layoutParams.height = d - 5
                chipYellow2.layoutParams.width = d - 5
                val mParamYellow2 = chipYellow2.layoutParams as RelativeLayout.LayoutParams
                mParamYellow2.leftMargin = 10 * d + 3 * d / 2
                mParamYellow2.topMargin = top
                chipYellow2.layoutParams = mParamYellow2
                yellow2 = 2
                x2 = 1
            }
            binding.chipYellow3 -> {
                chipYellow3.layoutParams.height = d - 5
                chipYellow3.layoutParams.width = d - 5
                val mParamYellow3 = chipYellow3.layoutParams as RelativeLayout.LayoutParams
                mParamYellow3.leftMargin = 10 * d + 3 * d / 2
                mParamYellow3.topMargin = top
                chipYellow3.layoutParams = mParamYellow3
                yellow3 = 2
                x3 = 1
            }
            binding.chipYellow4 -> {
                chipYellow4.layoutParams.height = d - 5
                chipYellow4.layoutParams.width = d - 5
                val mParamYellow4 = chipYellow4.layoutParams as RelativeLayout.LayoutParams
                mParamYellow4.leftMargin = 10 * d + 3 * d / 2
                mParamYellow4.topMargin = top
                chipYellow4.layoutParams = mParamYellow4
                yellow4 = 2
                x4 = 1
            }
            binding.chipBlue1 -> {
                chipBlue1.layoutParams.height = d - 5
                chipBlue1.layoutParams.width = d - 5
                val mParamBlue1 = chipBlue1.layoutParams as RelativeLayout.LayoutParams
                mParamBlue1.leftMargin = 11 * d + 3 * d / 2
                mParamBlue1.topMargin = top
                chipBlue1.layoutParams = mParamBlue1
                blue1 = 2
                x9 = 27
            }
            binding.chipBlue2 -> {
                chipBlue2.layoutParams.height = d - 5
                chipBlue2.layoutParams.width = d - 5
                val mParamBlue2 = chipBlue2.layoutParams as RelativeLayout.LayoutParams
                mParamBlue2.leftMargin = 11 * d + 3 * d / 2
                mParamBlue2.topMargin = top
                chipBlue2.layoutParams = mParamBlue2
                blue2 = 2
                x10 = 27
            }
            binding.chipBlue3 -> {
                chipBlue3.layoutParams.height = d - 5
                chipBlue3.layoutParams.width = d - 5
                val mParamBlue3 = chipBlue3.layoutParams as RelativeLayout.LayoutParams
                mParamBlue3.leftMargin = 11 * d + 3 * d / 2
                mParamBlue3.topMargin = top
                chipBlue3.layoutParams = mParamBlue3
                blue3 = 2
                x11 = 27
            }
            binding.chipBlue4 -> {
                chipBlue4.layoutParams.height = d - 5
                chipBlue4.layoutParams.width = d - 5
                val mParamBlue4 = chipBlue4.layoutParams as RelativeLayout.LayoutParams
                mParamBlue4.leftMargin = 11 * d + 3 * d / 2
                mParamBlue4.topMargin = top
                chipBlue4.layoutParams = mParamBlue4
                blue4 = 2
                x12 = 27
            }
        }
    }

    private fun fillOnBlue(chipOnBlue: ImageView) {
        when (chipOnBlue) {
            binding.chipGreen1 -> {
                chipGreen1.layoutParams.height = d - 5
                chipGreen1.layoutParams.width = d - 5
                val mParams1 = chipGreen1.layoutParams as RelativeLayout.LayoutParams
                mParams1.leftMargin = 14 * d
                mParams1.topMargin = 9 * d + top + 3 * d / 2
                chipGreen1.layoutParams = mParams1
                green1 = 2
                x13 = 40
            }
            binding.chipGreen2 -> {
                chipGreen2.layoutParams.height = d - 5
                chipGreen2.layoutParams.width = d - 5
                val mParams2 = chipGreen2.layoutParams as RelativeLayout.LayoutParams
                mParams2.leftMargin = 14 * d
                mParams2.topMargin = 9 * d + top + 3 * d / 2
                chipGreen2.layoutParams = mParams2
                green2 = 2
                x14 = 40
            }
            binding.chipGreen3 -> {
                chipGreen3.layoutParams.height = d - 5
                chipGreen3.layoutParams.width = d - 5
                val mParams3 = chipGreen3.layoutParams as RelativeLayout.LayoutParams
                mParams3.leftMargin = 14 * d
                mParams3.topMargin = 9 * d + top + 3 * d / 2
                chipGreen3.layoutParams = mParams3
                green3 = 2
                x15 = 40
            }
            binding.chipGreen4 -> {
                chipGreen4.layoutParams.height = d - 5
                chipGreen4.layoutParams.width = d - 5
                val mParams4 = chipGreen4.layoutParams as RelativeLayout.LayoutParams
                mParams4.leftMargin = 14 * d
                mParams4.topMargin = 9 * d + top + 3 * d / 2
                chipGreen4.layoutParams = mParams4
                green4 = 2
                x16 = 40
            }
            binding.chipYellow1 -> {
                chipYellow1.layoutParams.height = d - 5
                chipYellow1.layoutParams.width = d - 5
                val mParamYellow1 = chipYellow1.layoutParams as RelativeLayout.LayoutParams
                mParamYellow1.leftMargin = 14 * d
                mParamYellow1.topMargin = 10 * d + top + 3 * d / 2
                chipYellow1.layoutParams = mParamYellow1
                yellow1 = 2
                x1 = 1
            }
            binding.chipYellow2 -> {
                chipYellow2.layoutParams.height = d - 5
                chipYellow2.layoutParams.width = d - 5
                val mParamYellow2 = chipYellow2.layoutParams as RelativeLayout.LayoutParams
                mParamYellow2.leftMargin = 14 * d
                mParamYellow2.topMargin = 10 * d + top + 3 * d / 2
                chipYellow2.layoutParams = mParamYellow2
                yellow2 = 2
                x2 = 1
            }
            binding.chipYellow3 -> {
                chipYellow3.layoutParams.height = d - 5
                chipYellow3.layoutParams.width = d - 5
                val mParamYellow3 = chipYellow3.layoutParams as RelativeLayout.LayoutParams
                mParamYellow3.leftMargin = 14 * d
                mParamYellow3.topMargin = 10 * d + top + 3 * d / 2
                chipYellow3.layoutParams = mParamYellow3
                yellow3 = 2
                x3 = 1
            }
            binding.chipYellow4 -> {
                chipYellow4.layoutParams.height = d - 5
                chipYellow4.layoutParams.width = d - 5
                val mParamYellow4 = chipYellow4.layoutParams as RelativeLayout.LayoutParams
                mParamYellow4.leftMargin = 14 * d
                mParamYellow4.topMargin = 10 * d + top + 3 * d / 2
                chipYellow4.layoutParams = mParamYellow4
                yellow4 = 2
                x4 = 1
            }
            binding.chipRed1 -> {
                chipRed1.layoutParams.height = d - 5
                chipRed1.layoutParams.width = d - 5
                val mParamRed1 = chipRed1.layoutParams as RelativeLayout.LayoutParams
                mParamRed1.leftMargin = 14 * d
                mParamRed1.topMargin = 11 * d + top + 3 * d / 2
                chipRed1.layoutParams = mParamRed1
                red1 = 2
                x5 = 14
            }
            binding.chipRed2 -> {
                chipRed2.layoutParams.height = d - 5
                chipRed2.layoutParams.width = d - 5
                val mParamRed2 = chipRed2.layoutParams as RelativeLayout.LayoutParams
                mParamRed2.leftMargin = 14 * d
                mParamRed2.topMargin = 11 * d + top + 3 * d / 2
                chipRed2.layoutParams = mParamRed2
                red2 = 2
                x6 = 14
            }
            binding.chipRed3 -> {
                chipRed3.layoutParams.height = d - 5
                chipRed3.layoutParams.width = d - 5
                val mParamRed3 = chipRed3.layoutParams as RelativeLayout.LayoutParams
                mParamRed3.leftMargin = 14 * d
                mParamRed3.topMargin = 11 * d + top + 3 * d / 2
                chipRed3.layoutParams = mParamRed3
                red3 = 2
                x7 = 14
            }
            binding.chipRed4 -> {
                chipRed4.layoutParams.height = d - 5
                chipRed4.layoutParams.width = d - 5
                val mParamRed4 = chipRed4.layoutParams as RelativeLayout.LayoutParams
                mParamRed4.leftMargin = 14 * d
                mParamRed4.topMargin = 11 * d + top + 3 * d / 2
                chipRed4.layoutParams = mParamRed4
                red4 = 2
                x8 = 14
            }
        }
    }

    override fun onClick(chip: View) {
        chip.run { bringToFront() }
        val mP = chip.layoutParams as RelativeLayout.LayoutParams
        when (chip) {
            binding.chipGreen1 -> {
                when (green1) {
                    0 -> {
                        mP.leftMargin = 6 * d
                        mP.topMargin = top + 13 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        green1 = 1
                    }
                    2 -> {
                        fillGreen(chipGreen1)
                        setDiceClickable()
                    }
                    else -> x13 = positionOf(x13, chipGreen1)
                }
                checkPosition(chipGreen1)
            }
            binding.chipGreen2 -> {
                when (green2) {
                    0 -> {
                        mP.leftMargin = 6 * d
                        mP.topMargin = top + 13 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        green2 = 1
                    }
                    2 -> {
                        fillGreen(chipGreen2)
                        setDiceClickable()
                    }
                    else -> x14 = positionOf(x14, chipGreen2)
                }
                checkPosition(chipGreen2)
            }
            binding.chipGreen3 -> {
                when (green3) {
                    0 -> {
                        mP.leftMargin = 6 * d
                        mP.topMargin = top + 13 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        green3 = 1
                    }
                    2 -> {
                        fillGreen(chipGreen3)
                        setDiceClickable()
                    }
                    else -> x15 = positionOf(x15, chipGreen3)
                }
                checkPosition(chipGreen3)
            }
            binding.chipGreen4 -> {
                when (green4) {
                    0 -> {
                        mP.leftMargin = 6 * d
                        mP.topMargin = top + 13 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        green4 = 1
                    }
                    2 -> {
                        fillGreen(chipGreen4)
                        setDiceClickable()
                    }
                    else -> x16 = positionOf(x16, chipGreen4)
                }
                checkPosition(chipGreen4)
            }
            binding.chipYellow1 -> {
                when (yellow1) {
                    0 -> {
                        mP.leftMargin = d
                        mP.topMargin = top + 6 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        yellow1 = 1
                    }
                    2 -> {
                        fillYellow(chipYellow1)
                        setDiceClickable()
                    }
                    else -> x1 = positionOf(x1, chipYellow1)
                }
                checkPosition(chipYellow1)
            }
            binding.chipYellow2 -> {
                when (yellow2) {
                    0 -> {
                        mP.leftMargin = d
                        mP.topMargin = top + 6 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        yellow2 = 1
                    }
                    2 -> {
                        fillYellow(chipYellow2)
                        setDiceClickable()
                    }
                    else -> x2 = positionOf(x2, chipYellow2)
                }
                checkPosition(chipYellow2)
            }
            binding.chipYellow3 -> {
                when (yellow3) {
                    0 -> {
                        mP.leftMargin = d
                        mP.topMargin = top + 6 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        yellow3 = 1
                    }
                    2 -> {
                        fillYellow(chipYellow3)
                        setDiceClickable()
                    }
                    else -> x3 = positionOf(x3, chipYellow3)
                }
                checkPosition(chipYellow3)
            }
            binding.chipYellow4 -> {
                when (yellow4) {
                    0 -> {
                        mP.leftMargin = d
                        mP.topMargin = top + 6 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        yellow4 = 1
                    }
                    2 -> {
                        fillYellow(chipYellow4)
                        setDiceClickable()
                    }
                    else -> x4 = positionOf(x4, chipYellow4)
                }
                checkPosition(chipYellow4)
            }
            binding.chipRed1 -> {
                when (red1) {
                    0 -> {
                        mP.leftMargin = 8 * d
                        mP.topMargin = top + d
                        chip.layoutParams = mP
                        setDiceClickable()
                        red1 = 1
                    }
                    2 -> {
                        fillYellow(chipRed1)
                        setDiceClickable()
                    }
                    else -> x5 = positionOf(x5, chipRed1)
                }
                checkPosition(chipRed1)
            }
            binding.chipRed2 -> {
                when (red2) {
                    0 -> {
                        mP.leftMargin = 8 * d
                        mP.topMargin = top + d
                        chip.layoutParams = mP
                        setDiceClickable()
                        red2 = 1
                    }
                    2 -> {
                        fillYellow(chipRed2)
                        setDiceClickable()
                    }
                    else -> x6 = positionOf(x6, chipRed2)
                }
                checkPosition(chipRed2)
            }
            binding.chipRed3 -> {
                when (red3) {
                    0 -> {
                        mP.leftMargin = 8 * d
                        mP.topMargin = top + d
                        chip.layoutParams = mP
                        setDiceClickable()
                        red3 = 1
                    }
                    2 -> {
                        fillYellow(chipRed3)
                        setDiceClickable()
                    }
                    else -> x7 = positionOf(x7, chipRed3)
                }
                checkPosition(chipRed3)
            }
            binding.chipRed4 -> {
                if (red4 == 0) {
                    mP.leftMargin = 8 * d
                    mP.topMargin = top + d
                    chip.layoutParams = mP
                    setDiceClickable()
                    red4 = 1
                } else if (red4 == 2) {
                    fillYellow(chipRed4)
                    setDiceClickable()
                } else x8 = positionOf(x8, chipRed4)
                checkPosition(chipRed4)
            }
            binding.chipBlue1 -> {
                when (blue1) {
                    0 -> {
                        mP.leftMargin = 13 * d
                        mP.topMargin = top + 8 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        blue1 = 1
                    }
                    2 -> {
                        fillYellow(chipBlue1)
                        setDiceClickable()
                    }
                    else -> x9 = positionOf(x9, chipBlue1)
                }
                checkPosition(chipBlue1)
            }
            binding.chipBlue2 -> {
                when (blue2) {
                    0 -> {
                        mP.leftMargin = 13 * d
                        mP.topMargin = top + 8 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        blue2 = 1
                    }
                    2 -> {
                        fillYellow(chipBlue2)
                        setDiceClickable()
                    }
                    else -> x10 = positionOf(x10, chipBlue2)
                }
                checkPosition(chipBlue2)
            }
            binding.chipBlue3 -> {
                when (blue3) {
                    0 -> {
                        mP.leftMargin = 13 * d
                        mP.topMargin = top + 8 * d
                        chip.layoutParams = mP
                        setDiceClickable()
                        blue3 = 1
                    }
                    2 -> {
                        fillYellow(chipBlue3)
                        setDiceClickable()
                    }
                    else -> x11 = positionOf(x11, chipBlue3)
                }
                checkPosition(chipBlue3)
            }
            binding.chipBlue4 -> {
                when (blue4) {
                    0 -> {
                        mP.leftMargin = 13 * d
                        mP.topMargin = top + 8 * d
                        chip.layoutParams = mP
                        blue4 = 1
                    }
                    2 -> {
                        fillYellow(chipBlue4)
                        setDiceClickable()
                    }
                    else -> x12 = positionOf(x12, chipBlue4)
                }
                checkPosition(chipBlue4)
            }

            binding.diceGreen -> {
                n = rollDice(binding.diceGreen)
                //                Toast.makeText(getApplicationContext(), n + "was obtained", Toast.LENGTH_SHORT).show();
                val pt = PlayerNo
                setClickableFalse()
                diceGreen.isClickable = false
                if (PlayerNo % 4 == 1) {
                    if (green1 == 1) {
                        chipGreen1.setOnClickListener(this)
                    }
                    if (green2 == 1) {
                        chipGreen2.setOnClickListener(this)
                    }
                    if (green3 == 1) {
                        chipGreen3.setOnClickListener(this)
                    }
                    if (green4 == 1) {
                        chipGreen4.setOnClickListener(this)
                    }
                    when (n) {
                        6 -> {
                            green = 1
                            chipGreen1.setOnClickListener(this)
                            chipGreen2.setOnClickListener(this)
                            chipGreen3.setOnClickListener(this)
                            chipGreen4.setOnClickListener(this)
                        }
                        else -> {
                            PlayerNo++
                        }
                    }
                    n1 = n + x13 - 38
                    n2 = n + x14 - 38
                    n3 = n + x15 - 38
                    n4 = n + x16 - 38

                    if (n1 == 6 && chipGreen1.top > top + 6 * d && chipGreen1.left == 7 * d) {
                        chipGreen1.visibility = INVISIBLE
                        x13 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }
                    if (n2 == 6 && chipGreen2.top > top + 6 * d && chipGreen2.left == 7 * d) {
                        chipGreen2.visibility = INVISIBLE
                        x14 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }
                    if (n3 == 6 && chipGreen3.top > top + 6 * d && chipGreen3.left == 7 * d) {
                        chipGreen3.visibility = INVISIBLE
                        x15 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }
                    if (n4 == 6 && chipGreen4.top > top + 6 * d && chipGreen4.left == 7 * d) {
                        chipGreen4.visibility = INVISIBLE
                        x16 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }

                    if (n1 > 5 && chipGreen1.top > top + 6 * d && chipGreen1.left == 7 * d || chipGreen1.visibility == INVISIBLE) chipGreen1.isClickable = false
                    if (n2 > 5 && chipGreen2.top > top + 6 * d && chipGreen2.left == 7 * d || chipGreen2.visibility == INVISIBLE) chipGreen2.isClickable = false
                    if (n3 > 5 && chipGreen3.top > top + 6 * d && chipGreen3.left == 7 * d || chipGreen3.visibility == INVISIBLE) chipGreen3.isClickable = false
                    if (n4 > 5 && chipGreen4.top > top + 6 * d && chipGreen4.left == 7 * d || chipGreen4.visibility == INVISIBLE) chipGreen4.isClickable = false
                    if (!chipGreen1.isClickable && !chipGreen2.isClickable && !chipGreen3.isClickable && !chipGreen4.isClickable || green == 0) {
                        setDiceClickable()
                    }
                }
            }
            binding.diceYellow -> {
                n = rollDice(binding.diceYellow)
                val pt = PlayerNo
                setClickableFalse()
                diceYellow.isClickable = false
                if (PlayerNo % 4 == 2) {
                    if (yellow1 == 1) {
                        chipYellow1.setOnClickListener(this)
                    }
                    if (yellow2 == 1) {
                        chipYellow2.setOnClickListener(this)
                    }
                    if (yellow3 == 1) {
                        chipYellow3.setOnClickListener(this)
                    }
                    if (yellow4 == 1) {
                        chipYellow4.setOnClickListener(this)
                    }
                    when (n) {
                        6 -> {
                            yellow = 1
                            chipYellow1.setOnClickListener(this)
                            chipYellow2.setOnClickListener(this)
                            chipYellow3.setOnClickListener(this)
                            chipYellow4.setOnClickListener(this)
                        }
                        else -> {
                            PlayerNo++
                        }
                    }
                    n1 = x1 - 51 + n
                    n2 = x2 - 51 + n
                    n3 = x3 - 51 + n
                    n4 = x4 - 51 + n

                    if (n1 == 6) {
                        chipYellow1.visibility = INVISIBLE
                        x1 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }
                    if (n2 == 6) {
                        chipYellow2.visibility = INVISIBLE
                            x2 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }
                    if (n3 == 6) {
                        chipYellow3.visibility = INVISIBLE
                        x3 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }
                    if (n4 == 6) {
                        chipYellow4.visibility = INVISIBLE
                        x4 = 0
                        setDiceClickable()
                        PlayerNo = pt
                    }
                    if (n1 > 5 || chipYellow1.visibility == INVISIBLE) chipYellow1.isClickable = false
                    if (n2 > 5 || chipYellow2.visibility == INVISIBLE) chipYellow2.isClickable = false
                    if (n3 > 5 || chipYellow3.visibility == INVISIBLE) chipYellow3.isClickable = false
                    if (n4 > 5 || chipYellow4.visibility == INVISIBLE) chipYellow4.isClickable = false
                    if (!chipYellow1.isClickable && !chipYellow2.isClickable && !chipYellow3.isClickable && !chipYellow4.isClickable || yellow == 0) {
                        setDiceClickable()
                    }
                }
            }
            binding.diceBlue -> {
                n = rollDice(binding.diceBlue)
                val pt = PlayerNo
                setClickableFalse()
                diceBlue.isClickable = false
                if (PlayerNo % 4 == 0) {
                    if (blue1 == 1) {
                        chipBlue1.setOnClickListener(this)
                    }
                    if (blue2 == 1) {
                        chipBlue2.setOnClickListener(this)
                    }
                    if (blue3 == 1) {
                        chipBlue3.setOnClickListener(this)
                    }
                    if (blue4 == 1) {
                        chipBlue4.setOnClickListener(this)
                    }
                    when (n) {
                        6 -> {
                            blue = 1
                            chipBlue1.setOnClickListener(this)
                            chipBlue2.setOnClickListener(this)
                            chipBlue3.setOnClickListener(this)
                            chipBlue4.setOnClickListener(this)
                        }
                        else -> {
                            PlayerNo++
                        }
                    }
                    n1 = n + x9 - 25
                    n2 = n + x10 - 25
                    n3 = n + x11 - 25
                    n4 = n + x12 - 25
                    if (n1 == 6 && chipBlue1.left > 7 * d && chipBlue1.top == top + 7 * d) {
                        chipBlue1.visibility = INVISIBLE
                        PlayerNo = pt
                        x9 = 0
                        setDiceClickable()
                    }
                    if (n2 == 6 && chipBlue2.left > 7 * d && chipBlue2.top == top + 7 * d) {
                        chipBlue2.visibility = INVISIBLE
                        x10 = 0
                        PlayerNo = pt
                        setDiceClickable()
                    }
                    if (n3 == 6 && chipBlue3.left > 7 * d && chipBlue3.top == top + 7 * d) {
                        chipBlue3.visibility = INVISIBLE
                        PlayerNo = pt
                        x11 = 0
                        setDiceClickable()
                    }
                    if (n4 == 6 && chipBlue4.left > 7 * d && chipBlue4.top == top + 7 * d) {
                        chipBlue4.visibility = INVISIBLE
                        PlayerNo = pt
                        x12 = 0
                        setDiceClickable()
                    }
                    if (n1 > 5 && chipBlue1.left > 7 * d && chipBlue1.top == top + 7 * d || chipBlue1.visibility == INVISIBLE) chipBlue1.isClickable = false
                    if (n2 > 5 && chipBlue2.left > 7 * d && chipBlue2.top == top + 7 * d || chipBlue2.visibility == INVISIBLE) chipBlue2.isClickable = false
                    if (n3 > 5 && chipBlue3.left > 7 * d && chipBlue3.top == top + 7 * d || chipBlue3.visibility == INVISIBLE) chipBlue3.isClickable = false
                    if (n4 > 5 && chipBlue4.left > 7 * d && chipBlue4.top == top + 7 * d || chipBlue4.visibility == INVISIBLE) chipBlue4.isClickable = false
                    if (!chipBlue1.isClickable && !chipBlue2.isClickable && !chipBlue3.isClickable && !chipBlue4.isClickable || blue == 0) {
                        setDiceClickable()
                    }
                }
            }
            binding.diceRed -> {
                n = rollDice(binding.diceRed)
                val pt = PlayerNo
                setClickableFalse()
                diceRed.isClickable = false
                if (PlayerNo % 4 == 3) {
                    if (red1 == 1) {
                        chipRed1.setOnClickListener(this)
                    }
                    if (red2 == 1) {
                        chipRed2.setOnClickListener(this)
                    }
                    if (red3 == 1) {
                        chipRed3.setOnClickListener(this)
                    }
                    if (red4 == 1) {
                        chipRed4.setOnClickListener(this)
                    }
                    when (n) {
                        6 -> {
                            red = 1
                            chipRed1.setOnClickListener(this)
                            chipRed2.setOnClickListener(this)
                            chipRed3.setOnClickListener(this)
                            chipRed4.setOnClickListener(this)
                        }
                        else -> {
                            PlayerNo++
                        }
                    }
                    n1 = n + x5 - 12
                    n2 = n + x6 - 12
                    n3 = n + x7 - 12
                    n4 = n + x8 - 12

                    if (n1 == 6 && chipRed1.top < top + 7 * d && chipRed1.left == 7 * d) {
                        chipRed1.visibility = INVISIBLE
                        PlayerNo = pt
                        x5 = 0
                        setDiceClickable()
                    }
                    if (n2 == 6 && chipRed2.top < top + 7 * d && chipRed2.left == 7 * d) {
                        chipRed2.visibility = INVISIBLE
                        PlayerNo = pt
                        x6 = 0
                        setDiceClickable()
                    }
                    if (n3 == 6 && chipRed3.top < top + 7 * d && chipRed3.left == 7 * d) {
                        chipRed3.visibility = INVISIBLE
                        PlayerNo = pt
                        x7 = 0
                        setDiceClickable()
                    }
                    if (n4 == 6 && chipRed4.top < top + 7 * d && chipRed4.left == 7 * d) {
                        chipRed4.visibility = INVISIBLE
                        PlayerNo = pt
                        x8 = 0
                        setDiceClickable()
                    }
                    if (n1 > 5 && chipRed1.top < top + 7 * d && chipRed1.left == 7 * d || chipRed1.visibility == INVISIBLE) chipRed1.isClickable = false
                    if (n2 > 5 && chipRed2.top < top + 7 * d && chipRed2.left == 7 * d || chipRed2.visibility == INVISIBLE) chipRed2.isClickable = false
                    if (n3 > 5 && chipRed3.top < top + 7 * d && chipRed3.left == 7 * d || chipRed3.visibility == INVISIBLE) chipRed3.isClickable = false
                    if (n4 > 5 && chipRed4.top < top + 7 * d && chipRed4.left == 7 * d || chipRed4.visibility == INVISIBLE) chipRed4.isClickable = false
                    if (!chipRed1.isClickable && !chipRed2.isClickable && !chipRed3.isClickable && !chipRed4.isClickable || red == 0) {
                        setDiceClickable()
                    }
                }
            }
        }
//        if (chipGreen1.visibility == INVISIBLE && chipGreen2.visibility == INVISIBLE && chipGreen3.visibility == INVISIBLE && chipGreen4.visibility == INVISIBLE) {
//            val intent = Intent(this, winRed::class.java)
//            startActivity(intent)
//        }
//        if (chipYellow1.visibility == INVISIBLE && chipYellow2.visibility == INVISIBLE && chipYellow3.visibility == INVISIBLE && chipYellow4.visibility == INVISIBLE) {
//            val intent = Intent(this, winGreen::class.java)
//            startActivity(intent)
//        }
//        if (chipBlue1.visibility == INVISIBLE && chipBlue2.visibility == INVISIBLE && chipBlue3.visibility == INVISIBLE && chipBlue4.visibility == INVISIBLE) {
//            //game won by playerthree
//            val intent = Intent(this, winBlue::class.java)
//            startActivity(intent)
//        }
//        if (chipRed1.visibility == INVISIBLE && chipRed2.visibility == INVISIBLE && chipRed3.visibility == INVISIBLE && chipRed4.visibility == INVISIBLE) {
//            //game won by playerfour
//            val intent = Intent(this, winYellow::class.java)
//            startActivity(intent)
//        }
    }

    private fun setDiceClickable() {
        setClickableFalse()
        diceGreen.isClickable = true
        diceYellow.isClickable = true
        diceRed.isClickable = true
        diceBlue.isClickable = true
        diceGreen.setOnClickListener(this)
        diceYellow.setOnClickListener(this)
        diceRed.setOnClickListener(this)
        diceBlue.setOnClickListener(this)
        when (PlayerNo % 4) {
            1 -> {
                diceGreen.visibility = VISIBLE
                diceYellow.visibility = INVISIBLE
                diceRed.visibility = INVISIBLE
                diceBlue.visibility = INVISIBLE
            }
            2 -> {
                diceGreen.visibility = INVISIBLE
                diceYellow.visibility = VISIBLE
                diceRed.visibility = INVISIBLE
                diceBlue.visibility = INVISIBLE
            }
            3 -> {
                diceGreen.visibility = INVISIBLE
                diceYellow.visibility = INVISIBLE
                diceRed.visibility = VISIBLE
                diceBlue.visibility = INVISIBLE
            }
            0 -> {
                diceGreen.visibility = INVISIBLE
                diceYellow.visibility = INVISIBLE
                diceRed.visibility = INVISIBLE
                diceBlue.visibility = VISIBLE
            }
        }
    }

    private fun setClickableFalse() {
        chipGreen1.isClickable = false
        chipGreen2.isClickable = false
        chipGreen3.isClickable = false
        chipGreen4.isClickable = false
        chipYellow1.isClickable = false
        chipYellow2.isClickable = false
        chipYellow3.isClickable = false
        chipYellow4.isClickable = false
        chipRed1.isClickable = false
        chipRed2.isClickable = false
        chipRed3.isClickable = false
        chipRed4.isClickable = false
        chipBlue1.isClickable = false
        chipBlue2.isClickable = false
        chipBlue3.isClickable = false
        chipBlue4.isClickable = false
    }

    private fun startGame() {
        PlayerNo = 1
        setDiceClickable()
    }

    private fun positionOf(x: Int, chipX: ImageView): Int {
        var x = x
        setDiceClickable()
        val mParams = chipX.layoutParams as RelativeLayout.LayoutParams
        x += n
        if (chipX == binding.chipGreen1 || chipX == binding.chipGreen2 || chipX == binding.chipGreen3 || chipX == binding.chipGreen4 || chipX == binding.chipBlue1 || chipX == binding.chipBlue2 || chipX == binding.chipBlue3 || chipX == binding.chipBlue4 || chipX == binding.chipRed1 || chipX == binding.chipRed2 || chipX == binding.chipRed3 || chipX == binding.chipRed4) {
            if (x > 52) x -= 52
        }
        if (chipX == binding.chipYellow1 || chipX == binding.chipYellow2 || chipX == binding.chipYellow3 || chipX == binding.chipYellow4) {
            extraN = x - 51
            if (x > 51) {
                when (extraN) {
                    1 -> {
                        mParams.leftMargin = d
                        mParams.topMargin = top + 7 * d
                    }
                    2 -> {
                        mParams.leftMargin = 2 * d
                        mParams.topMargin = top + 7 * d
                    }
                    3 -> {
                        mParams.leftMargin = 3 * d
                        mParams.topMargin = top + 7 * d
                    }
                    4 -> {
                        mParams.leftMargin = 4 * d
                        mParams.topMargin = top + 7 * d
                    }
                    5 -> {
                        mParams.leftMargin = 5 * d
                        mParams.topMargin = top + 7 * d
                    }
                }
                chipX.layoutParams = mParams
            } else theCase(x, chipX)
        } else if (chipX == binding.chipRed1 || chipX == binding.chipRed2 || chipX == binding.chipRed3 || chipX == binding.chipRed4) {
            if (mParams.leftMargin <= 7 * d && x > 12 && x < 24) {
                extraN = x - 12
                when (extraN) {
                    1 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + d
                    }
                    2 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 2 * d
                    }
                    3 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 3 * d
                    }
                    4 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 4 * d
                    }
                    5 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 5 * d
                    }
                }
                chipX.layoutParams = mParams
            } else theCase(x, chipX)
        } else if (chipX == binding.chipBlue1 || chipX == binding.chipBlue2 || chipX == binding.chipBlue3 || chipX == binding.chipBlue4) {
            extraN = x - 25
            if (mParams.topMargin <= top + 7 * d && x > 25) {
                when (extraN) {
                    1 -> {
                        mParams.leftMargin = 13 * d
                        mParams.topMargin = top + 7 * d
                    }
                    2 -> {
                        mParams.leftMargin = 12 * d
                        mParams.topMargin = top + 7 * d
                    }
                    3 -> {
                        mParams.leftMargin = 11 * d
                        mParams.topMargin = top + 7 * d
                    }
                    4 -> {
                        mParams.leftMargin = 10 * d
                        mParams.topMargin = top + 7 * d
                    }
                    5 -> {
                        mParams.leftMargin = 9 * d
                        mParams.topMargin = top + 7 * d
                    }
                }
                chipX.layoutParams = mParams
            } else theCase(x, chipX)
        } else if (chipX == binding.chipGreen1 || chipX == binding.chipGreen2 || chipX == binding.chipGreen3 || chipX == binding.chipGreen4) {
            extraN = x - 38
            if (mParams.leftMargin >= 7 * d && x > 38) {
                when (extraN) {
                    1 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 13 * d
                    }
                    2 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 12 * d
                    }
                    3 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 11 * d
                    }
                    4 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 10 * d
                    }
                    5 -> {
                        mParams.leftMargin = 7 * d
                        mParams.topMargin = top + 9 * d
                    }
                }
                chipX.layoutParams = mParams
            } else theCase(x, chipX)
        }
        return x
    }

    private fun theCase(p: Int, pp: ImageView) {
        val mParams = pp.layoutParams as RelativeLayout.LayoutParams
        when (p) {
            1 -> {
                mParams.leftMargin = d
                mParams.topMargin = top + 6 * d
            }
            2 -> {
                mParams.leftMargin = 2 * d
                mParams.topMargin = top + 6 * d
            }
            3 -> {
                mParams.leftMargin = 3 * d
                mParams.topMargin = top + 6 * d
            }
            4 -> {
                mParams.leftMargin = 4 * d
                mParams.topMargin = top + 6 * d
            }
            5 -> {
                mParams.leftMargin = 5 * d
                mParams.topMargin = top + 6 * d
            }
            6 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 5 * d
            }
            7 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 4 * d
            }
            8 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 3 * d
            }
            9 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 2 * d
            }
            10 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + d
            }
            11 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top
            }
            12 -> {
                mParams.leftMargin = 7 * d
                mParams.topMargin = top
            }
            13 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top
            }
            14 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + d
            }
            15 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 2 * d
            }
            16 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 3 * d
            }
            17 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 4 * d
            }
            18 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 5 * d
            }
            19 -> {
                mParams.leftMargin = 9 * d
                mParams.topMargin = top + 6 * d
            }
            20 -> {
                mParams.leftMargin = 10 * d
                mParams.topMargin = top + 6 * d
            }
            21 -> {
                mParams.leftMargin = 11 * d
                mParams.topMargin = top + 6 * d
            }
            22 -> {
                mParams.leftMargin = 12 * d
                mParams.topMargin = top + 6 * d
            }
            23 -> {
                mParams.leftMargin = 13 * d
                mParams.topMargin = top + 6 * d
            }
            24 -> {
                mParams.leftMargin = 14 * d
                mParams.topMargin = top + 6 * d
            }
            25 -> {
                mParams.leftMargin = 14 * d
                mParams.topMargin = top + 7 * d
            }
            26 -> {
                mParams.leftMargin = 14 * d
                mParams.topMargin = top + 8 * d
            }
            27 -> {
                mParams.leftMargin = 13 * d
                mParams.topMargin = top + 8 * d
            }
            28 -> {
                mParams.leftMargin = 12 * d
                mParams.topMargin = top + 8 * d
            }
            29 -> {
                mParams.leftMargin = 11 * d
                mParams.topMargin = top + 8 * d
            }
            30 -> {
                mParams.leftMargin = 10 * d
                mParams.topMargin = top + 8 * d
            }
            31 -> {
                mParams.leftMargin = 9 * d
                mParams.topMargin = top + 8 * d
            }
            32 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 9 * d
            }
            33 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 10 * d
            }
            34 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 11 * d
            }
            35 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 12 * d
            }
            36 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 13 * d
            }
            37 -> {
                mParams.leftMargin = 8 * d
                mParams.topMargin = top + 14 * d
            }
            38 -> {
                mParams.leftMargin = 7 * d
                mParams.topMargin = top + 14 * d
            }
            39 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 14 * d
            }
            40 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 13 * d
            }
            41 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 12 * d
            }
            42 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 11 * d
            }
            43 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 10 * d
            }
            44 -> {
                mParams.leftMargin = 6 * d
                mParams.topMargin = top + 9 * d
            }
            45 -> {
                mParams.leftMargin = 5 * d
                mParams.topMargin = top + 8 * d
            }
            46 -> {
                mParams.leftMargin = 4 * d
                mParams.topMargin = top + 8 * d
            }
            47 -> {
                mParams.leftMargin = 3 * d
                mParams.topMargin = top + 8 * d
            }
            48 -> {
                mParams.leftMargin = 2 * d
                mParams.topMargin = top + 8 * d
            }
            49 -> {
                mParams.leftMargin = d
                mParams.topMargin = top + 8 * d
            }
            50 -> {
                mParams.leftMargin = 0
                mParams.topMargin = top + 8 * d
            }
            51 -> {
                mParams.leftMargin = 0
                mParams.topMargin = top + 7 * d
            }
            52 -> {
                mParams.leftMargin = 0
                mParams.topMargin = top + 6 * d
            }
        }
        pp.layoutParams = mParams
    }

    private fun checkPosition(v: ImageView) {
        val mP = v.layoutParams as RelativeLayout.LayoutParams
        if (v == binding.chipYellow1 || v == binding.chipYellow2 || v == binding.chipYellow3 || v == binding.chipYellow4) {
            val lm1: Int = chipRed1.left
            val tm1: Int = chipRed1.top
            if (lm1 == mP.leftMargin && tm1 == mP.topMargin) {
                fillOnYellow(chipRed1)
            }
            val lm2: Int = chipRed2.left
            val tm2: Int = chipRed2.top
            if (lm2 == mP.leftMargin && tm2 == mP.topMargin) {
                fillOnYellow(chipRed2)
            }
            val lm3: Int = chipRed3.left
            val tm3: Int = chipRed3.top
            if (lm3 == mP.leftMargin && tm3 == mP.topMargin) {
                fillOnYellow(chipRed3)
            }
            val lm4: Int = chipRed4.left
            val tm4: Int = chipRed4.top
            if (lm4 == mP.leftMargin && tm4 == mP.topMargin) {
                fillOnYellow(chipRed4)
            }
            val lm5: Int = chipBlue1.left
            val tm5: Int = chipBlue1.top
            if (lm5 == mP.leftMargin && tm5 == mP.topMargin) {
                fillOnYellow(chipBlue1)
            }
            val lm6: Int = chipBlue2.left
            val tm6: Int = chipBlue2.top
            if (lm6 == mP.leftMargin && tm6 == mP.topMargin) {
                fillOnYellow(chipBlue2)
            }
            val lm7: Int = chipBlue3.left
            val tm7: Int = chipBlue3.top
            if (lm7 == mP.leftMargin && tm7 == mP.topMargin) {
                fillOnYellow(chipBlue3)
            }
            val lm8: Int = chipBlue4.left
            val tm8: Int = chipBlue4.top
            if (lm8 == mP.leftMargin && tm8 == mP.topMargin) {
                fillOnYellow(chipBlue4)
            }
            val lm9: Int = chipGreen1.left
            val tm9: Int = chipGreen1.top
            if (lm9 == mP.leftMargin && tm9 == mP.topMargin) {
                fillOnYellow(chipGreen1)
            }
            val lm10: Int = chipGreen2.left
            val tm10: Int = chipGreen2.top
            if (lm10 == mP.leftMargin && tm10 == mP.topMargin) {
                fillOnYellow(chipGreen2)
            }
            val lm11: Int = chipGreen3.left
            val tm11: Int = chipGreen3.top
            if (lm11 == mP.leftMargin && tm11 == mP.topMargin) {
                fillOnYellow(chipGreen3)
            }
            val lm12: Int = chipGreen4.left
            val tm12: Int = chipGreen4.top
            if (lm12 == mP.leftMargin && tm12 == mP.topMargin) {
                fillOnYellow(chipGreen4)
            }
        }
        if (v == binding.chipRed1 || v == binding.chipRed2 || v == binding.chipRed3 || v == binding.chipRed4) {
            val lm1: Int = chipYellow1.left
            val tm1: Int = chipYellow1.top
            if (lm1 == mP.leftMargin && tm1 == mP.topMargin) {
                fillOnRed(chipYellow1)
            }
            val lm2: Int = chipYellow2.left
            val tm2: Int = chipYellow2.top
            if (lm2 == mP.leftMargin && tm2 == mP.topMargin) {
                fillOnRed(chipYellow2)
            }
            val lm3: Int = chipYellow3.left
            val tm3: Int = chipYellow3.top
            if (lm3 == mP.leftMargin && tm3 == mP.topMargin) {
                fillOnRed(chipYellow3)
            }
            val lm4: Int = chipYellow4.left
            val tm4: Int = chipYellow4.top
            if (lm4 == mP.leftMargin && tm4 == mP.topMargin) {
                fillOnRed(chipYellow4)
            }
            val lm5: Int = chipBlue1.left
            val tm5: Int = chipBlue1.top
            if (lm5 == mP.leftMargin && tm5 == mP.topMargin) {
                fillOnRed(chipBlue1)
            }
            val lm6: Int = chipBlue2.left
            val tm6: Int = chipBlue2.top
            if (lm6 == mP.leftMargin && tm6 == mP.topMargin) {
                fillOnRed(chipBlue2)
            }
            val lm7: Int = chipBlue3.left
            val tm7: Int = chipBlue3.top
            if (lm7 == mP.leftMargin && tm7 == mP.topMargin) {
                fillOnRed(chipBlue3)
            }
            val lm8: Int = chipBlue4.left
            val tm8: Int = chipBlue4.top
            if (lm8 == mP.leftMargin && tm8 == mP.topMargin) {
                fillOnRed(chipBlue4)
            }
            val lm9: Int = chipGreen1.left
            val tm9: Int = chipGreen1.top
            if (lm9 == mP.leftMargin && tm9 == mP.topMargin) {
                fillOnRed(chipGreen1)
            }
            val lm10: Int = chipGreen2.left
            val tm10: Int = chipGreen2.top
            if (lm10 == mP.leftMargin && tm10 == mP.topMargin) {
                fillOnRed(chipGreen2)
            }
            val lm11: Int = chipGreen3.left
            val tm11: Int = chipGreen3.top
            if (lm11 == mP.leftMargin && tm11 == mP.topMargin) {
                fillOnRed(chipGreen3)
            }
            val lm12: Int = chipGreen4.left
            val tm12: Int = chipGreen4.top
            if (lm12 == mP.leftMargin && tm12 == mP.topMargin) {
                fillOnRed(chipGreen4)
            }
        }
        if (v == binding.chipBlue1 || v == binding.chipBlue2 || v == binding.chipBlue3 || v == binding.chipBlue4) {
            val lm1: Int = chipYellow1.left
            val tm1: Int = chipYellow1.top
            if (lm1 == mP.leftMargin && tm1 == mP.topMargin) {
                fillOnBlue(chipYellow1)
            }
            val lm2: Int = chipYellow2.left
            val tm2: Int = chipYellow2.top
            if (lm2 == mP.leftMargin && tm2 == mP.topMargin) {
                fillOnBlue(chipYellow2)
            }
            val lm3: Int = chipYellow3.left
            val tm3: Int = chipYellow3.top
            if (lm3 == mP.leftMargin && tm3 == mP.topMargin) {
                fillOnBlue(chipYellow3)
            }
            val lm4: Int = chipYellow4.left
            val tm4: Int = chipYellow4.top
            if (lm4 == mP.leftMargin && tm4 == mP.topMargin) {
                fillOnBlue(chipYellow4)
            }
            val lm5: Int = chipRed1.left
            val tm5: Int = chipRed1.top
            if (lm5 == mP.leftMargin && tm5 == mP.topMargin) {
                fillOnBlue(chipRed1)
            }
            val lm6: Int = chipRed2.left
            val tm6: Int = chipRed2.top
            if (lm6 == mP.leftMargin && tm6 == mP.topMargin) {
                fillOnBlue(chipRed2)
            }
            val lm7: Int = chipRed3.left
            val tm7: Int = chipRed3.top
            if (lm7 == mP.leftMargin && tm7 == mP.topMargin) {
                fillOnBlue(chipRed3)
            }
            val lm8: Int = chipRed4.left
            val tm8: Int = chipRed4.top
            if (lm8 == mP.leftMargin && tm8 == mP.topMargin) {
                fillOnBlue(chipRed4)
            }
            val lm9: Int = chipGreen1.left
            val tm9: Int = chipGreen1.top
            if (lm9 == mP.leftMargin && tm9 == mP.topMargin) {
                fillOnBlue(chipGreen1)
            }
            val lm10: Int = chipGreen2.left
            val tm10: Int = chipGreen2.top
            if (lm10 == mP.leftMargin && tm10 == mP.topMargin) {
                fillOnBlue(chipGreen2)
            }
            val lm11: Int = chipGreen3.left
            val tm11: Int = chipGreen3.top
            if (lm11 == mP.leftMargin && tm11 == mP.topMargin) {
                fillOnBlue(chipGreen3)
            }
            val lm12: Int = chipGreen4.left
            val tm12: Int = chipGreen4.top
            if (lm12 == mP.leftMargin && tm12 == mP.topMargin) {
                fillOnBlue(chipGreen4)
            }
        }
        if (v == binding.chipGreen1 || v == binding.chipGreen2 || v == binding.chipGreen3 || v == binding.chipGreen4) {
            val lm1: Int = chipYellow1.left
            val tm1: Int = chipYellow1.top
            if (lm1 == mP.leftMargin && tm1 == mP.topMargin) {
                fillOnGreen(chipYellow1)
            }
            val lm2: Int = chipYellow2.left
            val tm2: Int = chipYellow2.top
            if (lm2 == mP.leftMargin && tm2 == mP.topMargin) {
                fillOnGreen(chipYellow2)
            }
            val lm3: Int = chipYellow3.left
            val tm3: Int = chipYellow3.top
            if (lm3 == mP.leftMargin && tm3 == mP.topMargin) {
                fillOnGreen(chipYellow3)
            }
            val lm4: Int = chipYellow4.left
            val tm4: Int = chipYellow4.top
            if (lm4 == mP.leftMargin && tm4 == mP.topMargin) {
                fillOnGreen(chipYellow4)
            }
            val lm5: Int = chipRed1.left
            val tm5: Int = chipRed1.top
            if (lm5 == mP.leftMargin && tm5 == mP.topMargin) {
                fillOnGreen(chipRed1)
            }
            val lm6: Int = chipRed2.left
            val tm6: Int = chipRed2.top
            if (lm6 == mP.leftMargin && tm6 == mP.topMargin) {
                fillOnGreen(chipRed2)
            }
            val lm7: Int = chipRed3.left
            val tm7: Int = chipRed3.top
            if (lm7 == mP.leftMargin && tm7 == mP.topMargin) {
                fillOnGreen(chipRed3)
            }
            val lm8: Int = chipRed4.left
            val tm8: Int = chipRed4.top
            if (lm8 == mP.leftMargin && tm8 == mP.topMargin) {
                fillOnGreen(chipRed4)
            }
            val lm9: Int = chipBlue1.left
            val tm9: Int = chipBlue1.top
            if (lm9 == mP.leftMargin && tm9 == mP.topMargin) {
                fillOnGreen(chipBlue1)
            }
            val lm10: Int = chipBlue2.left
            val tm10: Int = chipBlue2.top
            if (lm10 == mP.leftMargin && tm10 == mP.topMargin) {
                fillOnGreen(chipBlue2)
            }
            val lm11: Int = chipBlue3.left
            val tm11: Int = chipBlue3.top
            if (lm11 == mP.leftMargin && tm11 == mP.topMargin) {
                fillOnGreen(chipBlue3)
            }
            val lm12: Int = chipBlue4.left
            val tm12: Int = chipBlue4.top
            if (lm12 == mP.leftMargin && tm12 == mP.topMargin) {
                fillOnGreen(chipBlue4)
            }
        }
    }

    private fun rollDice(diceImage: ImageView): Int {
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
        return diceRoll
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
