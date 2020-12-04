package com.gameleira.projetomarvel.home.hqDetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gameleira.projetomarvel.R

class HQDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_details)

        supportActionBar?.hide()
    }
}