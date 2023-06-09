package com.example.androidlab0329_7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv : Button
    lateinit var btnRemainder : Button; lateinit var btnChange : Button
    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 : String;
    var result : Int? = null
    var click : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = click.toString() + "회 계산기"
        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)

        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnRemainder = findViewById<Button>(R.id.BtnRemainder)
        btnChange = findViewById<Button>(R.id.BtnChange)

        textResult = findViewById<TextView>(R.id.TextResult)


        btnAdd.setOnClickListener{
            try{
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                textResult.text= "계산 결과 : " + result.toString()
                click = click + 1;
                title = click.toString() + "회 계산기"
            }
            catch(e:NumberFormatException){
                println("failed")
            }
            false
        }

        btnSub.setOnClickListener{
            try{
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                textResult.text= "계산 결과 : " + result.toString()
                click = click + 1;
                title = click.toString() + "회 계산기"
            }
            catch (e:NumberFormatException){
                println("failed")
            }
            false
        }

        btnMul.setOnClickListener{
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()
                click = click + 1;
                title = click.toString() + "회 계산기"
            }
            catch (e:NumberFormatException){
                println("failed")
            }
            false
        }

        btnDiv.setOnClickListener{
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                try {
                    result = Integer.parseInt(num1) / Integer.parseInt(num2)
                    textResult.text = "계산 결과 : " + result.toString()
                    click = click + 1;
                    title = click.toString() + "회 계산기"
                }
                catch (e:ArithmeticException){
                    println("Divided_by_Zero_Exception")
                }
            }
            catch (e:NumberFormatException){
                println("failed")
            }
            false
        }

        btnRemainder.setOnClickListener{
            try{
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                try {
                    result = Integer.parseInt(num1) % Integer.parseInt(num2)
                    textResult.text = "계산 결과 : " + result.toString()
                    click = click + 1;
                    title = click.toString() + "회 계산기"
                }
                catch (e:ArithmeticException){
                    println("Divided_by_Zero_Exception")
                }
            }
            catch (e:NumberFormatException){
                println("failed")
            }
            false
        }

        btnChange.setOnClickListener{
            if(result != null){
                edit1.setText(result.toString())
                edit2.text = null
                click = click + 1;
                title = click.toString() + "회 계산기"
                result = null;
                textResult.text= "계산 결과 : "
            }
            else{
                println("failed")
            }
            false
        }
    }
}