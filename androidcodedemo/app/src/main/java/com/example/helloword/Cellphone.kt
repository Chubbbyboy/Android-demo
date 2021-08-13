package com.example.helloword

data class Cellphone(val name:String,val price:Double)
fun main(){
    val  c1= Cellphone("xiaomi",2999.9)
    val  c3= Cellphone("xiaomi",2999.9)
    val  c2= Cellphone("huawei",2999.8)
    println(c1)
    println(c2)
    println(c1==c3)
}