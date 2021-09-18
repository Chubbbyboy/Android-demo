package com.example.broadcasttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login_layout.*

class LoginActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        loginfunc()
    }
    fun loginfunc(){
        login.setOnClickListener {
            if (accountEdit.text.toString().equals("123") && passwordEdit.text.toString().equals("qwer")) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SuccessActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "登录帐号或密码错误", Toast.LENGTH_SHORT).show()
            }
        }
    }
}