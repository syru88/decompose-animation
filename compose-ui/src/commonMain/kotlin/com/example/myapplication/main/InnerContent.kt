package com.example.myapplication.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.myapplication.shared.main.InnerComponent
import com.example.myapplication.shared.main.InnerComponent.InnerChild

@Composable
internal fun InnerContent(component: InnerComponent) {
    Children(stack = component.stack, animation = stackAnimation()) {
        when (val instance = it.instance) {
            is InnerChild.InnerMain -> Text(text = "counter: ${instance.counter}")
        }
    }
}