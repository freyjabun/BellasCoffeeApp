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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellascoffeeapp.ui.theme.BellasTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BellasTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = Color(0xFFCCC2DC),
                                titleContentColor = Color.Black,
                            ),
                            title = {
                                Text("Bella's Coffee Lab")
                            }
                        )
                    },
                ) { innerPadding ->
                    Column (modifier = Modifier
                        .padding(innerPadding)){
                        Greeting()
                    }
                }
                }
            }
        }
    }


@Composable
fun Greeting(){
    var name by rememberSaveable { mutableStateOf("") }
    var enteredName by rememberSaveable { mutableStateOf("") }
    var introVisible by rememberSaveable { mutableStateOf( true) }
    var welcomeVisible by rememberSaveable { mutableStateOf(false) }

    AnimatedVisibility(visible = introVisible,

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
            TextInput()
        }
    }
    AnimatedVisibility(visible = welcomeVisible,
        enter = fadeIn(tween(durationMillis = 3000,delayMillis = 1500))


    ) {
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text(text = "Welcome, $enteredName",
                fontSize = 30.sp)
        }
    }
}

@Composable
fun TextInput(){
    var name by rememberSaveable { mutableStateOf("") }
    var enteredName by rememberSaveable { mutableStateOf("") }
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
            onValueChange = { name = it
            }
        )
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    enteredName = name
                }
            },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        )
        {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Add"
            )
        }
    }
}

