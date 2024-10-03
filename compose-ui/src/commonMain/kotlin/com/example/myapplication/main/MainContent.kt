package com.example.myapplication.main

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.items
import com.example.myapplication.shared.main.MainComponent
import com.example.myapplication.shared.main.PreviewMainComponent

@Composable
internal fun MainContent(
    component: MainComponent,
    modifier: Modifier = Modifier,
) {
    MaterialTheme {
        Surface(modifier = modifier.fillMaxSize().windowInsetsPadding(WindowInsets.systemBars)) {
            Column {
                Text(text = "Feature MainScreen Id ${(component.stack.items.component1().instance as? MainComponent.Child.Main)?.id}")
                Children(
                    stack = component.stack,
                    modifier = Modifier.fillMaxSize(),
                    animation = stackAnimation(fade())
                ) {
                    when (val instance = it.instance) {
                        is MainComponent.Child.Main -> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                Column {
                                    Text(text = "View MainScreem Id: ${instance.id}")

                                    Button(onClick = component::onShowWelcomeClicked) {
                                        Text(text = "Show Welcome screen for 50 ms")
                                    }
                                }


                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainPreview() {
    MainContent(PreviewMainComponent)
}
