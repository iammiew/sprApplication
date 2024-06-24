package com.example.data.appbar.model

import com.google.firebase.firestore.PropertyName

data class AppBarModel(
    @get:PropertyName("title")
    @PropertyName("title")
    val title: String = "",

    @get:PropertyName("size")
    @PropertyName("size")
    val size: Int = 0,
//
//    @get:PropertyName("size")
//    @PropertyName("size")
//    val size: String = "",

//    @get:PropertyName("test")
//    @PropertyName("test")
//    val test: List<ValuesTest>? = null,
)

//data class AppBarModelTitle(
//    val title: String? = ""
//)
