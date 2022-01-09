package com.example.sunuludo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sunuludo.databinding.ActivityMainBinding
import com.example.sunuludo.views.OfflineActivity
import com.google.firebase.auth.FirebaseAuth


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        val progressBar = binding.progressBar
        val loginButton = binding.loginButton

        binding.offlineButton.setOnClickListener {
            val offlineActivityIntent = Intent(this, OfflineActivity::class.java)
            startActivity(offlineActivityIntent)
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        if (currentUser != null) {
            progressBar.visibility = INVISIBLE
            loginButton.visibility = INVISIBLE
        } else {
            loginButton.setOnClickListener {
                progressBar.visibility = VISIBLE
                mAuth.signInAnonymously().addOnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
//                        loginMessage.visibility = VISIBLE
                        progressBar.visibility = INVISIBLE
                    }
                }
                mAuth.signInAnonymously().addOnFailureListener { e ->
                    Log.e("TAG", e.message!!)
                }
            }
        }
    }
}