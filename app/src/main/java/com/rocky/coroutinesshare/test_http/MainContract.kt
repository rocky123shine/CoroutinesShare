package com.rocky.coroutinesshare.test_http

import com.rocky.coroutinesshare.http.Gank
import com.rocky.coroutinesshare.test_http.base.MvpPresenter
import com.rocky.coroutinesshare.test_http.base.MvpView

class MainContract {
    interface View: MvpView {
        fun showLoadingView()
        fun showLoadingSuccessView(granks: List<Gank>)
        fun showLoadingErrorView()
    }

    interface Presenter: MvpPresenter<View> {
        fun syncWithContext()
        fun syncNoneWithContext()
        fun asyncWithContextForAwait()
        fun asyncWithContextForNoAwait()
        fun adapterCoroutineQuery()
        fun retrofitCoroutine()
    }
}