package com.rick.kotlininandroid.other.sc

// Type Check and Smart Cast
fun test(obj: Any) {
    if (obj is String) obj.split("")
}