package com.example.activitytest

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : BaseActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        button1.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "你点击了add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "你点击了remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    fun clickButton() {
        button1.setOnClickListener {
            progressBar.progress+=10
            if(progressBar.progress >= 100) {
                image.setImageResource(R.drawable.jiaoao)
            }
        }
    }

    override fun onClick(v: View?) {
        Toast.makeText(this,"您点击了button1",Toast.LENGTH_SHORT).show()
        when(v?.id){
            R.id.button1->{
                AlertDialog.Builder(this)
                    .apply {
                        setTitle("这是一个弹窗")
                        setMessage("这是很重要的东西，您确定要删除吗？")
                        setCancelable(false)
                        setPositiveButton("OK"){
                            dialog, which ->
                        }
                        setNegativeButton("Cancel"){
                            dialog, which ->
                        }
                        show()
                    }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
