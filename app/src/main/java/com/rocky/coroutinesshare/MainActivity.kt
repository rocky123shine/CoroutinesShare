package com.rocky.coroutinesshare

import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MainActivity : BaseActiivty() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchDocs {
            //这是网络请求 是耗时操作 不能直接放在主线程 这里只是伪代码 作为展示 正常需要通过callback  然后回到主线程展示数据
            val result = getData("url")
            show(result)
        }



        fetchDocs {
            // 错误实例 suspend函数只能在协程中调用
            // Suspend function should be called only from a coroutine
            // or another suspend function
            //val result = coroutines_getData("url")
            val result = async {//这里的async是什么？？？
                // Suspend 又是什么？？
                // Suspend的作用是什么
                //suspend：暂停当前协程的执行，保存所有的局部变量
                //resume：从协程被暂停的地方继续执行协程。
                //注意******  suspend修饰的函数并不意味着运行在子线程中。
                coroutines_getData("url")
            }


            show(result)

        }

    }

    private fun getData(s: String) = ""

    private fun show(result: Any) {
        TODO("Not yet implemented")
    }

    //简单的例子  获取网络数据 展示出来
    private fun fetchDocs(method: () -> Unit) {
        method()
    }

    suspend fun coroutines_getData(s: String): String = withContext(Dispatchers.IO) {
        ""
    }

    //////=========


}