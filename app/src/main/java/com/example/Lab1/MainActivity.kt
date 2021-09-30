package com.example.Lab1

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.tapadoo.alerter.Alerter


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val confirm=findViewById<Button>(R.id.Confirm)
        val question:TextInputEditText=findViewById(R.id.Question)
        confirm.setOnClickListener {
            val text= question.text.toString();
            val result:TextView=findViewById(R.id.result)
            val yb:RadioButton=findViewById(R.id.Yes)
            val nb:RadioButton=findViewById(R.id.No)
            if (text!=""){
                if(yb.isChecked||nb.isChecked){
                    val answer:String = if(yb.isChecked){
                        "Да"
                    } else{
                        "Нет"
                    }
                    result.text= "Вопрос: $text\nОтвет: $answer"
                } else{
                    Alerter.create(this)
                        .setTitle("Ошибка")
                        .setText("Выберите ответ")
                        .setDuration(3000)
                        .setBackgroundColorInt(Color.BLACK).show()
                }
            } else{
                Alerter.create(this)
                    .setTitle("Ошибка")
                    .setText("Введите вопрос")
                    .setBackgroundColorInt(Color.BLACK)
                    .setDuration(3000).show()
            }
        }
    }

}