package com.rocky.coroutinesshare

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() {
    newSingleThreadContext("Context1").use { ctx1 ->
        newSingleThreadContext("Context2").use { ctx2 ->

            runBlocking(ctx1) {
                log("started in context1")
                withContext(ctx2) {
                    log("started in context2")
                }
                log("back to context1")
            }
        }

    }


}