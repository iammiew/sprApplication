package com.example.data.appbar.repository

import com.example.data.appbar.model.AppBarCommonModel

interface AppBarCommonRepository {
    fun getAppBar(): AppBarCommonModel
}

//interface UserRepository {
//    fun findUser(name : String): User?
//    fun addUsers(users : List<User>)
//}

class AppBarCommonRepositoryImpl : AppBarCommonRepository {

    override fun getAppBar(): AppBarCommonModel {
       return AppBarCommonModel("สวัสดีครับ")
    }
}