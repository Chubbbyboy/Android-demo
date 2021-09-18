package com.example.filesaveactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        saveButton.setOnClickListener {
            val editor = getSharedPreferences("data", MODE_PRIVATE).edit()
            editor.putString("name", "Tom")
            editor.putInt("age", 22)
            editor.putBoolean("married", false)
            editor.apply()
        }
        load()
    }
    fun load(){
        load.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name1 = prefs.getString("name","")
            val age1 = prefs.getInt("age",0)
            val married1 = prefs.getBoolean("married",false)
            Log.d("MainActivity", "name is $name1")
            Log.d("MainActivity", "age is $age1")
            Log.d("MainActivity", "married is $married1")
            name.setText(name1.toString())
            age.setText(age1.toString())
            married.setText(married1.toString())
        }
    }
}
