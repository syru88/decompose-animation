package com.example.myapplication.shared.main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface MainComponent {

    val counter: Int

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Main(val id: String) : Child
    }


    fun onShowWelcomeClicked()
}
