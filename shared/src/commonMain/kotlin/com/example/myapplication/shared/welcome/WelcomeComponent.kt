package com.example.myapplication.shared.welcome

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface WelcomeComponent {

    fun onBackClicked()

}

class DefaultWelcomeComponent(
    private val componentContext: ComponentContext,
    private val onFinished: () -> Unit,
) : WelcomeComponent, ComponentContext by componentContext {

    init {
        CoroutineScope(Dispatchers.Main).launch {
            delay(50)
            onFinished()
        }
    }

    override fun onBackClicked() {
        onFinished()
    }
}
