package com.example.cse225ca1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class SplashScreenMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_main)

        val button:Button=findViewById(R.id.Bt1)
        val ratingBar:RatingBar=findViewById(R.id.RatingBar)
        val button1:Button=findViewById(R.id.bt2)

        button1.setOnClickListener {
            val rating=ratingBar.rating
            Toast.makeText(this,"Rating is: "+rating,Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            val i=Intent(this,ToolBar::class.java)
            startActivity(i)

        }
    }
}