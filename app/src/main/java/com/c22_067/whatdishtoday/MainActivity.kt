package com.c22_067.whatdishtoday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.c22_067.whatdishtoday.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            val popUp = layoutInflater.inflate(R.layout.popup_login, null)
            dialogBuilder.setTitle("Sign In")
            dialogBuilder.setView(popUp)
            dialogBuilder.show()
        }

        binding.btnRegister.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            val popUp = layoutInflater.inflate(R.layout.popup_register, null)
            dialogBuilder.setTitle("Sign Up")
            dialogBuilder.setView(popUp)
            dialogBuilder.show()
        }
    }
}