package com.example.sunuludo.models

import java.io.Serializable
import java.util.*

data class Game(
//    var idGame: String = UUID.randomUUID().toString(),
//    var playerNumber: Number = 2,
    var playerGreen: String = "",
    var playerYellow: String = "",
    var playerRed: String = "",
    var playerBlue: String = ""
): Serializable
