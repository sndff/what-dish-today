package com.c22_067.whatdishtoday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.c22_067.whatdishtoday.databinding.ActivityMainBinding
import com.c22_067.whatdishtoday.ui.home.DetailRecipeActivity
import com.c22_067.whatdishtoday.ui.home.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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

        binding.btnHome.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

    }

}