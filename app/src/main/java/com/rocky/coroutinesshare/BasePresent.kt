package com.rocky.coroutinesshare

import android.content.Context
import android.util.AttributeSet
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BasePresent : CoroutineScope {
    private val job = Job()

    //自己提供协程上下文环境
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    fun detached() {
        job.cancel()
    }

}