package com.example.application_dagger_hilt_retrofit.data.model

class MyClass(private var name: String) {
    companion object Factory {
        fun create(): MyClass = MyClass("Luan")
        val j: String = ""
    }
}