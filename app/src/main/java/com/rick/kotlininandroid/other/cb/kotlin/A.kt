package com.rick.kotlininandroid.other.cb.kotlin

class A {
    fun action(onDone: () -> Unit) {
        // do things ex. internet
        println("Download is start.")
        onDone()
    }
}

fun main() {
    val a = A()
    a.action {
        println("Download is finish.")
    }
}