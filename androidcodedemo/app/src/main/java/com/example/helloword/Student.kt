package com.example.helloword

class Student( name:String, age:Int,val grade:Int) : Person(name,age),Study {
    constructor(name:String,age:Int):this(name,age,0)

    override fun doHomework() {
        println("做家庭作业")
    }

    override fun readBooks() {
        println("学生读书")
    }

}
fun main(){
    var s=Student("hg",22)
    s.doHomework()
    s.readBooks()
}