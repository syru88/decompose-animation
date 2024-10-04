package com.example.myapplication.shared.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.example.myapplication.shared.main.InnerComponent.InnerChild
import kotlinx.serialization.Serializable

interface InnerComponent {
    val stack: Value<ChildStack<*, InnerChild>>

    sealed class InnerChild {
        class InnerMain(val counter: Int) : InnerChild()
    }

}

class DefaultInnerComponent(private val counter: Int, componentContext: ComponentContext) :
    InnerComponent,
    ComponentContext by componentContext {

    @Serializable
    private sealed interface InnerConfig {
        @Serializable
        data object InnerMain : InnerConfig
    }

    private val navigation = StackNavigation<InnerConfig>()

    override val stack: Value<ChildStack<*, InnerChild>> = childStack(
        source = navigation,
        serializer = InnerConfig.serializer(),
        initialConfiguration = InnerConfig.InnerMain,
        handleBackButton = true,
        childFactory = ::child
    )

    private fun child(config: InnerConfig, componentContext: ComponentContext): InnerChild =
        when (config) {
            InnerConfig.InnerMain -> InnerChild.InnerMain(counter)
        }

}