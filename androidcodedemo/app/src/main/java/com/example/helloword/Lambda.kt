package com.example.helloword

fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val map = mapOf(
        "Apple" to 1,
        "Banana" to 2,
        "Orange" to 3,
        "Pear" to 4,
        "Grape" to 5,
        "Watermelon" to 6
    )
    val list1 = list.map { it.toUpperCase() }
    val list2 = list.filter { it.length <= 5 }.map { it.toUpperCase() }
    for (fruit in list2) {
        println(fruit)
    }
    val maxLengthFruit = list.maxBy { it.length }
    println(maxLengthFruit)
    val name="hg"
    val age=22
    println("name is $name,age is $age")
}