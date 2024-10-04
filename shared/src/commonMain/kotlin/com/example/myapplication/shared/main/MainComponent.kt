package com.example.myapplication.shared.main

import com.arkivanov.decompose.ComponentContext

interface MainComponent {

    val counter: Int
    val innerComponent: InnerComponent

    fun onShowWelcomeClicked()
}

class DefaultMainComponent(
    componentContext: ComponentContext,
    override val counter: Int,
    private val onShowWelcome: () -> Unit,
) : MainComponent, ComponentContext by componentContext {

    override val innerComponent = DefaultInnerComponent(counter, componentContext)

    override fun onShowWelcomeClicked() {
        onShowWelcome()
    }
}
