package com.renatoarg.mvvmkotlin.data

data class User(val name: String,
                val email : String) {

    override fun toString(): String {
        return "$name - $email"
    }
}