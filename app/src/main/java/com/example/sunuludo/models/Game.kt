package com.example.sunuludo.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable
import java.util.*

@IgnoreExtraProperties
data class Game(
    var playerGreen: String = "",
    var playerYellow: String = "",
    var playerRed: String = "",
    var playerBlue: String = ""
): Serializable
