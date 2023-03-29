package com.example.androidlab0329_5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var linLayer : LinearLayout
    lateinit var mybtn : Button
    var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mybtn = findViewById<Button>(R.id.Mybtn)
        linLayer = findViewById<LinearLayout>(R.id.LinLay)

        mybtn.setOnTouchListener{ view, motionEvent->
            count = count + 1
            if(count % 3 == 0){
                linLayer.setBackgroundColor(Color.parseColor("#FF0000"))
            }
            else if(count % 3 == 1){
                linLayer.setBackgroundColor(Color.parseColor("#00FF00"))
            }
            else if(count % 3 == 2){
                linLayer.setBackgroundColor(Color.parseColor("#0000FF"))
            }
            println(count)
            false
        }
    }

}