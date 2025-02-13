package com.example.bellascoffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellascoffeeapp.ui.theme.BellasCoffeeAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BellasCoffeeAppTheme {
                Greeting()
                }
            }
        }
    }


@Composable
fun Greeting(){
    var name by remember { mutableStateOf("") }
    var enteredName by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf( true) }
    AnimatedVisibility(visible = isVisible,
        enter = fadeIn(initialAlpha = 0.0f,
            animationSpec = tween(durationMillis = 10000)
        ),
        exit = fadeOut(animationSpec = tween(durationMillis = 1000))
    )
    {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp,
                alignment = Alignment.CenterVertically),
            modifier = Modifier.fillMaxSize(),

            ) {
            Text(
                text = "Welcome to Bella's Coffee Lab.",
                fontSize = 20.sp,
            )
            Text(
                text = "What is your name?",
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { text ->
                        name = text
                    }
                )
                Button(
                    onClick = {
                        if (name.isNotBlank()) {
                            enteredName = name
                            isVisible = !isVisible
                        }
                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                )
                {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add"
                    )
                }
            }
        }
    }

}


