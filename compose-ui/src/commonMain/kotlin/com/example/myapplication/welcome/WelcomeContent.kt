package com.example.myapplication.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.shared.welcome.WelcomeComponent

@Composable
internal fun WelcomeContent(
    component: WelcomeComponent,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        backgroundColor = Color.Yellow,
        topBar = {
            TopAppBar(
                title = { Text(text = "Welcome Screen") },
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = component::onBackClicked,
            ) {
                Text("Main screen")
            }
        }
    }
}
