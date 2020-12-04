package com.gameleira.projetomarvel.home.hq.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gameleira.projetomarvel.R

class HqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq)

        supportActionBar?.title = getString(R.string.marvel);

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HQFragment.newInstance())
                .commitNow()
        }
    }
}