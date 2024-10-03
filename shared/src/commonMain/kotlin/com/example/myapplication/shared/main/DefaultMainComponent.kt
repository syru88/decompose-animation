package com.example.myapplication.shared.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.example.myapplication.shared.main.MainComponent.Child
import kotlinx.serialization.Serializable

class DefaultMainComponent(
    componentContext: ComponentContext,
    override val counter: Int,
    private val onShowWelcome: () -> Unit,
) : MainComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Main,
            handleBackButton = true,
            childFactory = ::child,
        )

    override fun onShowWelcomeClicked() {
        onShowWelcome()
    }

    private fun child(config: Config, childComponentContext: ComponentContext): Child =
        when (config) {
            is Config.Main -> Child.Main(this.hashCode().toString())
        }


    init {
        println("### DefaultMainComponent init ${this.hashCode()}")
    }


    @Serializable
    private sealed interface Config {
        @Serializable
        data object Main : Config
    }
}

