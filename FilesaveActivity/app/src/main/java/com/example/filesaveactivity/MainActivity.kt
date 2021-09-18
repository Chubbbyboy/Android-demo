package com.example.filesaveactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputText = load()
        if(inputText.isNotEmpty()){
            editText.setText(inputText)
            editText.setSelection(inputText.length)
            Toast.makeText(this,"恢复成功",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputText = editText.text.toString()
        save(inputText)
    }
    fun save(inputText:String){
        val output = openFileOutput("data", Context.MODE_PRIVATE)
        val writer = BufferedWriter(OutputStreamWriter(output))
        writer.use {
            it.write(inputText)
        }
    }
    fun load():String{
        val content = StringBuilder()
        val input = openFileInput("data")
        val reader = BufferedReader(InputStreamReader(input))
        reader.use{
            reader.forEachLine {
                content.append(it)
            }
        }
        return content.toString()
    }
}