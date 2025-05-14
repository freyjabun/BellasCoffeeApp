package com.example.bellascoffeeapp.orders.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.bellascoffeeapp.orders.model.Drink
import com.example.bellascoffeeapp.orders.viewmodel.OrderDetailsViewModel
import kotlinx.serialization.Serializable

@Composable
fun OrderDetailsView(viewModel: OrderDetailsViewModel){
    val extras by viewModel.extrasList.collectAsState()


}


@Serializable
data class OrderDetails(
    val drink: Drink
    )