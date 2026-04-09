package com.example.labapplication.data

import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    var userLogin: String? = null
    var userPassword: String? = null
    var userName: String = ""
    var userSurname: String = ""
    var users = mutableListOf(User(
        "Lucky",
        "1234",
        "Никита",
        "Матигоров"
    ))

    fun changeName(value: String){
        val user = users.first{u -> u.login == userLogin}
        user.name = value
        userName = value
    }

    fun changeSurname(value: String){
        val user = users.first{u -> u.login == userLogin}
        user.surname = value
        userSurname = value
    }

    fun addUser(
        login: String,
        password: String,
        name: String? = null,
        surname: String? = null) : Boolean{
        if (users.firstOrNull{u -> u.login == login} == null){
            users.add(User(login, password, name, surname))
            return true
        }
        return false
    }

    fun authorization(login: String, password: String): Boolean {
        val user = users.firstOrNull{u -> u.login == login} ?: return false
        if (user.password == password){
            userLogin = login
            userPassword = password
            userName = user.name ?: ""
            userSurname = user.surname ?: ""
            return true
        }
        return false
    }
}