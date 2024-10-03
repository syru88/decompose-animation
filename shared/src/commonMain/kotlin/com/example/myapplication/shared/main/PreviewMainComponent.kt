package com.example.myapplication.shared.main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

object PreviewMainComponent : MainComponent {
    override val counter = -1
    override val stack: Value<ChildStack<*, MainComponent.Child>>
        get() = error("Not implemented")

    override fun onShowWelcomeClicked() {}
}
