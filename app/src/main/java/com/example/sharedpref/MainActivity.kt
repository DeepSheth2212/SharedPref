package com.example.sharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        save.setOnClickListener {
            val text = textView.text.toString()

            editor.apply{
                putString("text",text)
                //commit() it will block main thread
                apply()
            }
        }

        load.setOnClickListener {
            val text = sharedPref.getString("text",null)
            textView.setText(text)
        }
    }
}