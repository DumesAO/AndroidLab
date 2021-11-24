package com.example.Lab1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tapadoo.alerter.Alerter


class MainActivity : AppCompatActivity() , InputFragment.OnTextSent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFragment = InputFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, inputFragment)
            .commit()
    }
    override fun sendData(questionText: String, ybChecked: Boolean, nbChecked: Boolean) {
        val resultFragment = ResultFragment()
        val bundle = Bundle()
        if (questionText.isNotEmpty()) {
            if (ybChecked || nbChecked) {
                bundle.putString("questionText", questionText)
                bundle.putBoolean("ybChecked", ybChecked)
                bundle.putBoolean("nbChecked", nbChecked)
                resultFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, resultFragment).addToBackStack(null).commit()
            } else {
                Alerter.create(this)
                    .setTitle("Ошибка")
                    .setText("Выберите ответ")
                    .setDuration(3000)
                    .setBackgroundColorInt(Color.BLACK).show()

            }
        } else {
            Alerter.create(this)
                .setTitle("Ошибка")
                .setText("Введите вопрос")
                .setBackgroundColorInt(Color.BLACK)
                .setDuration(3000).show()

        }
    }
}