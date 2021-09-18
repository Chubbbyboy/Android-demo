package com.example.filesaveactivity

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sqlite_ativity.*

class SQLiteAtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_ativity)
        val database = MyDatabaseHelper(this, "BookStore.db", 13);
        createDatabase.setOnClickListener {
            database.writableDatabase
        }
        addData.setOnClickListener {
            val db = database.writableDatabase
            val values1 = ContentValues().apply{
                // 开始组装第一条数据
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 454)
                put("price", 16.96)
            }
            db.insert("Book",null,values1)
            val values2 = ContentValues().apply {
// 开始组装第二条数据
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book",null,values2)
            Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show()
        }
    }
}