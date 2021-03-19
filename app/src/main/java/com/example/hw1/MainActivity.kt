package com.example.hw1

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butSh= findViewById<Button>(R.id.button)
        val map = mutableMapOf<String,String>()
        val txtView = findViewById<TextView>(R.id.textView)
        val edTxt= findViewById<EditText>(R.id.editText1)

        edTxt.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val parts = editText1.text.split(" ")
                if(parts.size == 4 ) {
                    val Student = object {
                        var id = (System.currentTimeMillis().toString())
                        var name = parts[0]
                        var sername = parts[1]
                        var grade = parts[2]
                        var birthdayYear = parts[3]
                    }
                    map += Student.id to
                            (Student.name + " "+ Student.sername +  " "+  Student.grade + " "+  Student.birthdayYear)
                    edTxt.setText("")
                    txtView.text = "Данные записаны"
                }
                else{txtView.text = "Вы ввели недостаточно данных"}
                return@setOnKeyListener true
            }
            return@setOnKeyListener false }

        butSh.setOnClickListener {
            txtView.setText("")
            for((key, value) in map){
                txtView.append(key + " " + value + "\n")
            }
        }


    }
}