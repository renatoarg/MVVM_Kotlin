package com.renatoarg.mvvmkotlin.ui.users

import androidx.lifecycle.ViewModel
import com.renatoarg.mvvmkotlin.data.User
import com.renatoarg.mvvmkotlin.data.UserRepository

class UsersViewModel(private  val userRepository: UserRepository)
    : ViewModel() {

    fun getUsers() = userRepository.getUsers()

    fun addUser(user: User) = userRepository.addUser(user)
}