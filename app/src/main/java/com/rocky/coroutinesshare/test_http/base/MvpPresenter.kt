package com.rocky.coroutinesshare.test_http.base
import androidx.annotation.UiThread

interface MvpPresenter<V: MvpView> {

    @UiThread
    fun attachView(view: V)

    @UiThread
    fun detachView()
}