package com.c22_067.whatdishtoday.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.databinding.ActivityDetailMenuBinding
import com.c22_067.whatdishtoday.databinding.ActivityMenuMakananBinding
import com.c22_067.whatdishtoday.ui.detail.DetailMenuActivity

class MenuMakananActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuMakananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuMakananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, DetailMenuActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}