package com.example.labapplaction

/**
 * Пользователь.
 * @property login Логин пользователя.
 * @property password Пароль пользователя.
 * @constructor Создаёт пользователя с назначенными логином и паролем.
 * @param login Логин пользователя.
 * @param password Пароль пользователя.
 *
 * @author Lucky
 * @since 1.0
 * @sample userExample
 */
class User(val login : String, var password : String) {
    /**
     * Проверка пароля.
     * @param password Пароль.
     * @return true если пароли совпадают, иначе false
     *
     * @author Lucky
     * @since 1.0
     * @sample verificationPasswordExample
     */
    fun verificationPassword(password : String) : Boolean = this.password == password
}

/**
 * Пример класса User.
 *
 * @since 1.0
 * @author Lucky
 */
private fun userExample(){
    val user = User("Lucky", "LuckyPassword")
    user.login // Lucky
    user.password // LuckyPassword
}

/**
 * Пример функции verificationPassword.
 *
 * @since 1.0
 * @author Lucky
 */
private fun verificationPasswordExample(){
    val user = User("Lucky", "LuckyPassword")
    val trueResult : Boolean = user.verificationPassword("LuckyPassword") // True
    val falseResult : Boolean = user.verificationPassword("Password") // False
}