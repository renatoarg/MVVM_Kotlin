package com.renatoarg.mvvmkotlin.utils

import com.renatoarg.mvvmkotlin.data.FakeDatabase
import com.renatoarg.mvvmkotlin.data.UserRepository
import com.renatoarg.mvvmkotlin.ui.users.UsersViewModelFactory

object InjectorUtils {

    fun provideUsersViewModelFactory(): UsersViewModelFactory {
        val userRepository = UserRepository.getInstance(FakeDatabase.getInstance().userDao)
        return UsersViewModelFactory(userRepository)
    }
}