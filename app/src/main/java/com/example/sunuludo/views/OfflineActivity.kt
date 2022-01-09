package com.example.sunuludo.views

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.R
import com.example.sunuludo.databinding.ActivityOfflineBinding
import com.example.sunuludo.models.Game
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


@Suppress("DEPRECATION")
class OfflineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOfflineBinding
    val EXTRA_MESSAGE = "com.example.android.sunuludo.extra.MESSAGE"
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var newGame: Game
    private val user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_offline)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        firebaseDatabase = FirebaseDatabase.getInstance("https://sunu-ludo-default-rtdb.firebaseio.com/")
        databaseReference = firebaseDatabase.reference

        binding.startButton.setOnClickListener {
            val intentGameOfflineActivity = Intent(this, GameOfflineActivity::class.java)
            val game = Game(
                binding.greenNameEditText.text.toString(),
                binding.yellowNameEditText.text.toString(),
                binding.redNameEditText.text.toString(),
                binding.blueNameEditText.text.toString()
            )
            val green = binding.greenNameEditText.text.toString()
            val yellow = binding.yellowNameEditText.text.toString()
            val red = binding.redNameEditText.text.toString()
            val blue = binding.blueNameEditText.text.toString()
            if (TextUtils.isEmpty(green) || TextUtils.isEmpty(yellow) || TextUtils.isEmpty(red) || TextUtils.isEmpty(
                    blue
                )) {
                Toast.makeText(this, "Veuillez entrer le nom des joueur", Toast.LENGTH_SHORT).show()
            } else {
                addDataToFirebase(green, yellow, red, blue)
                intentGameOfflineActivity.putExtra(EXTRA_MESSAGE, game)
                startActivity(intentGameOfflineActivity)
            }
        }
    }

    private fun addDataToFirebase(green: String, yellow: String, red: String, blue: String) {
        newGame = Game(green, yellow, red, blue)
        val uid = user?.uid

        if (uid != null) {
            databaseReference.child("games").child(uid).setValue(newGame)
                .addOnSuccessListener {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show()
                }
        }
    }
}