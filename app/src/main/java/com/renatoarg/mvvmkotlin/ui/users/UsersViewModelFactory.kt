package com.renatoarg.mvvmkotlin.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.renatoarg.mvvmkotlin.data.UserRepository

class UsersViewModelFactory(private val userRepository: UserRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(userRepository) as T
    }
}