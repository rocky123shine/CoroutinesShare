package com.rocky.coroutinesshare

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")
//-Dkotlinx.coroutines.debug
fun main() = runBlocking {
    val a = async {
        log("hello word")
        10
    }
    val b = async {
        log("welcome")
        20
    }
    log("The result is ${a.await() * b.await()}")


}