package com.example.bellascoffeeapp.orders.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Composable
fun Coffee(){
    Text(text = "Hi it's coffee time")
}

@Serializable
object Coffee