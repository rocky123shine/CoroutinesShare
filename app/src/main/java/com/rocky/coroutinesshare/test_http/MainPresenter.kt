package com.rocky.coroutinesshare.test_http

import android.util.Log
import com.rocky.coroutinesshare.http.Repository
import com.rocky.coroutinesshare.http.TAG
import com.rocky.coroutinesshare.test_http.base.BasePresenter
import kotlinx.coroutines.launch

class MainPresenter: MainContract.Presenter, BasePresenter<MainContract.View>() {

    override fun syncWithContext() {
        presenterScope.launch {
            val time = System.currentTimeMillis()
            view.showLoadingView()
            try {
                val ganks = Repository.querySyncWithContext()
                view.showLoadingSuccessView(ganks)
            } catch (e: Throwable) {
                e.printStackTrace()
                view.showLoadingErrorView()
            } finally {
                Log.d(TAG, "耗时：${System.currentTimeMillis() - time}")
            }
        }
    }

    override fun syncNoneWithContext() {
        presenterScope.launch {
            val time = System.currentTimeMillis()
            view.showLoadingView()
            try {
                val ganks = Repository.querySyncNoneWithContext()
                view.showLoadingSuccessView(ganks)
            } catch (e: Throwable) {
                e.printStackTrace()
                view.showLoadingErrorView()
            } finally {
                Log.d(TAG, "耗时：${System.currentTimeMillis() - time}")
            }
        }
    }

    override fun asyncWithContextForAwait() {
        presenterScope.launch {
            val time = System.currentTimeMillis()
            view.showLoadingView()
            try {
                val ganks = Repository.queryAsyncWithContextForAwait()
                view.showLoadingSuccessView(ganks)
            } catch (e: Throwable) {
                e.printStackTrace()
                Log.d(TAG, "error: ${e.message}")
                view.showLoadingErrorView()
            } finally {
                Log.d(TAG, "耗时：${System.currentTimeMillis() - time}")
            }
        }
    }

    override fun asyncWithContextForNoAwait() {
        presenterScope.launch {
            val time = System.currentTimeMillis()
            view.showLoadingView()
            try {
                val ganks = Repository.queryAsyncWithContextForNoAwait()
                view.showLoadingSuccessView(ganks)
            } catch (e: Throwable) {
                e.printStackTrace()
                view.showLoadingErrorView()
            } finally {
                Log.d(TAG, "耗时：${System.currentTimeMillis() - time}")
            }
        }
    }

    override fun adapterCoroutineQuery() {
        presenterScope.launch {
            val time = System.currentTimeMillis()
            view.showLoadingView()
            try {
                val ganks = Repository.adapterCoroutineQuery()
                view.showLoadingSuccessView(ganks)
            } catch (e: Throwable) {
                e.printStackTrace()
                view.showLoadingErrorView()
            } finally {
                Log.d(TAG, "耗时：${System.currentTimeMillis() - time}")
            }
        }
    }

    override fun retrofitCoroutine() {
        presenterScope.launch {
            val time = System.currentTimeMillis()
            view.showLoadingView()
            try {
                val ganks = Repository.retrofitSuspendQuery()
                view.showLoadingSuccessView(ganks)
            } catch (e: Throwable) {
                e.printStackTrace()
                view.showLoadingErrorView()
            } finally {
                Log.d(TAG, "耗时：${System.currentTimeMillis() - time}")
            }
        }
    }
}
