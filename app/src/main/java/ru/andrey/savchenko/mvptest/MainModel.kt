package ru.andrey.savchenko.mvptest

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import org.reactivestreams.Publisher
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by savchenko on 27.04.18.
 */
class MainModel(app:Application) : AndroidViewModel(app) {
    var users: MutableLiveData<MutableList<User>>? = null

    fun getUsers(): LiveData<MutableList<User>>? {
        if (users == null) {
            loadUsers()
        }
        return users
    }

    fun addUser() {
        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    users?.value?.add(User(rand(0, 25), "test"))
                    users?.postValue(users?.value)
                })
    }


    fun rand(from: Int, to: Int): Int {
        return Random().nextInt(to - from) + from
    }

    private fun loadUsers() {
        users = MutableLiveData<MutableList<User>>()
        users?.value = mutableListOf(
                User(1, "test1"),
                User(2, "test2"),
                User(3, "test3"),
                User(4, "test4"),
                User(5, "test5"))
    }


}