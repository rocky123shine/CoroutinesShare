package com.rocky.coroutinesshare

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * 这是声明协程的作用域
 * 一.提供协程环境 CoroutineContext
 *      1。通过 by MainScope() 来实现CoroutineContext的赋值
 *      2。实现CoroutineScope接口方法
 * 二.在destroy生命周期中取消所有协程操作
 */
open class BaseActiivty : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

}