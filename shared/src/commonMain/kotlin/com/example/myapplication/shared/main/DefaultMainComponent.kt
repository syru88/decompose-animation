package com.example.myapplication.shared.main

import com.arkivanov.decompose.ComponentContext

class DefaultMainComponent(
    componentContext: ComponentContext,
    override val counter: Int,
    private val onShowWelcome: () -> Unit,
) : MainComponent, ComponentContext by componentContext {

    override fun onShowWelcomeClicked() {
        onShowWelcome()
    }
}
