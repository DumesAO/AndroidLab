package com.example.androidLab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class StorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        val fileInputStream: FileInputStream? = openFileInput("AndroidLabData")
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String?
        while (run {
                text = bufferedReader.readLine()
                text
            } != null) {
            stringBuilder.append(text)
        }
        val data = stringBuilder.toString()
        val storageFragment = StorageFragment()
        val bundle = Bundle()

        bundle.putString("storage", data)
        storageFragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.storage_container, storageFragment)
            .commit()
    }

}