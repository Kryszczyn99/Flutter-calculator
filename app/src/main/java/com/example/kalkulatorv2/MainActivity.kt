package com.example.kalkulatorv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.exit_button)
        button.setOnClickListener {
            finish()
            exitProcess(0)
        }
        val button2 = findViewById<Button>(R.id.about_button)
        button2.setOnClickListener {
            val intent = Intent(this,InfoActivity::class.java)
            startActivity(intent)
            finish()
        }
        val button3 = findViewById<Button>(R.id.button_first)
        button3.setOnClickListener {
            val intent = Intent(this,SimpleActivity::class.java)
            startActivity(intent)
            finish()
        }
        val button4 = findViewById<Button>(R.id.adv_button)
        button4.setOnClickListener {
            val intent = Intent(this,AdvActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}