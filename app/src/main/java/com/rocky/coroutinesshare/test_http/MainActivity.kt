package com.rocky.coroutinesshare.test_http

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rocky.coroutinesshare.R
import com.rocky.coroutinesshare.http.Gank
import com.rocky.coroutinesshare.http.TAG
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {
    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        syncWithContextBtn.setOnClickListener {
            presenter.syncWithContext()
        }
        syncNoneWithContext.setOnClickListener {
            presenter.syncNoneWithContext()
        }
        asyncWithContextForAwait.setOnClickListener {
            presenter.asyncWithContextForAwait()
        }
        asyncWithContextForNoAwait.setOnClickListener {
            presenter.asyncWithContextForNoAwait()
        }
        adapterBtn.setOnClickListener {
            presenter.adapterCoroutineQuery()
        }
        retrofitBtn.setOnClickListener {
            presenter.retrofitCoroutine()
        }
        cancelBtn.setOnClickListener {
            presenter.detachView()
        }
    }

    override fun showLoadingView() {
        loadingBar.showSelf()
    }

    override fun showLoadingSuccessView(granks: List<Gank>) {
        loadingBar.hideSelf()
        textView.text = "请求结束，数据条数：${granks.size}"
        Toast.makeText(this, "加载成功", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "请求结果：$granks")
    }

    override fun showLoadingErrorView() {
        loadingBar.hideSelf()
        Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onBackPressed() {
        finish()
    }
}

fun View.showSelf() {
    this.visibility = View.VISIBLE
}

fun View.hideSelf() {
    this.visibility = View.GONE
}