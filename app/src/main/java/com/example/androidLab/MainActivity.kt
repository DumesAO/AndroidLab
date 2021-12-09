package com.example.androidLab

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tapadoo.alerter.Alerter


class MainActivity : AppCompatActivity(), InputFragment.OnTextSent, InputFragment.ShowStorage {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputFragment = InputFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, inputFragment)
            .commit()
    }

    override fun sendData(questionText: String, answer: String) {
        val resultFragment = ResultFragment()
        val bundle = Bundle()
        val alerter = Alerter.create(this)
            .setTitle("Ошибка")
            .setDuration(3000)
            .setBackgroundColorInt(Color.BLACK)
        if (questionText.isNotEmpty()) {
            if (answer != "") {
                bundle.putString("questionText", questionText)
                bundle.putString("answer", answer)
                resultFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, resultFragment).addToBackStack(null).commit()
            } else {
                alerter.setText("Выберите ответ").show()

            }
        } else {
            alerter.setText("Выберите вопрос").show()

        }
    }

    override fun show() {
        val intent = Intent(this, StorageActivity::class.java)
        startActivity(intent)
    }
}