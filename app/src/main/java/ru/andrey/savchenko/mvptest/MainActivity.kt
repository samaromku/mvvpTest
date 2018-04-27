package ru.andrey.savchenko.mvptest

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MainModel::class.java)
        model.addUser()
        model.getUsers()?.observe(this, Observer<MutableList<User>> {
            tvUsers.text = it.toString()
        })
    }
}
