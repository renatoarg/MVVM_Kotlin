package com.renatoarg.mvvmkotlin.ui.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.renatoarg.mvvmkotlin.R
import com.renatoarg.mvvmkotlin.data.User
import com.renatoarg.mvvmkotlin.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_users.*
import java.lang.StringBuilder

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        initializaUi()
    }

    private fun initializaUi() {
        val factory = InjectorUtils.provideUsersViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(UsersViewModel::class.java)

        viewModel.getUsers().observe(this, Observer { users ->
            val strongBuilder = StringBuilder()
            users.forEach{ user ->
                strongBuilder.append("$user\n\n")
            }
            textView_users.text = strongBuilder.toString()
        })

        button_add_user.setOnClickListener{
            val user = User(editText_name.text.toString(), editText_email.text.toString())
            viewModel.addUser(user)
            editText_name.setText("")
            editText_email.setText("")
        }
    }
}
