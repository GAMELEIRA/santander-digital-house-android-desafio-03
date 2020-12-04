package com.gameleira.projetomarvel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.register)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val btnSave = findViewById<Button>(R.id.btnSave_signUpActivity )
        btnSave.setOnClickListener{
            val intent = Intent(this, ComicActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
        return true
    }

    override fun onBackPressed() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}