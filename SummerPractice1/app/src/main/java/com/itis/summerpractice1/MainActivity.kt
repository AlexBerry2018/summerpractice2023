package com.itis.summerpractice1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var bEval: Button? = null

    // four text fields
    var etName: EditText? = null
    var etWeigth: EditText? = null
    var etAge: EditText? = null
    var etHeight: EditText? = null

    var textView: TextView? = null

    var isAllFieldsChecked = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bEval = findViewById(R.id.button)

        etName = findViewById(R.id.name)
        etWeigth = findViewById(R.id.weigth)
        etAge = findViewById(R.id.age)
        etHeight = findViewById(R.id.height)

        textView = findViewById(R.id.result)
        bEval!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                isAllFieldsChecked = CheckAllFields()

                if (isAllFieldsChecked) {
                    var v = ((etName!!.length() + etHeight!!.text.toString().toInt()) * 2 - 1 + etWeigth!!.text.toString().toDouble())  - etAge!!.text.toString().toInt()
                    textView!!.text = v.toString()
                }else{
                    textView!!.text = "Данные введены неверно"
                }
            }
        })
    }

    private fun CheckAllFields(): Boolean {
        if (etName!!.length() <= 0 || etName!!.length() > 50) {
            etName!!.error = "Введите корректное имя"
            return false
        }
        if (etAge!!.length() == 0 || etAge!!.text.toString().toInt() <= 0 || etAge!!.text.toString().toInt() >= 150) {
            etAge!!.error = "Введите корректный возраст"
            return false
        }
        if (etHeight!!.length() == 0 || etHeight!!.text.toString().toInt() <= 0 || etHeight!!.text.toString().toInt() >= 250) {
            etHeight!!.error = "Введите корректный рост"
            return false
        }
        if (etWeigth!!.length() == 0 || etWeigth!!.text.toString().toDouble() <= 0 || etWeigth!!.text.toString().toDouble() > 250) {
            etWeigth!!.error = "Введите корректный вес"
            return false
        }
        return true
    }
}
