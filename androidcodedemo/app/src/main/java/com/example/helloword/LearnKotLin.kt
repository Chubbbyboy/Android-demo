package com.example.helloword

import kotlin.math.max

fun main(){
    for (i in  10 downTo 2){
        println(i)
    }
    println(test(1,2))
}
fun test(parame1:Int,parame2: Int):Int = if(parame1>parame2) parame1 else parame2
fun getScore(name:String) =when{
    name.startsWith("Tom")->60
    name=="jack"->70
    name=="lily"->80
    else->0
}