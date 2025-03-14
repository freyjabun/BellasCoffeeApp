package com.example.bellascoffeeapp.orders.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.bellascoffeeapp.R
import com.example.bellascoffeeapp.orders.model.OrderItem
import com.example.bellascoffeeapp.orders.viewmodel.OrdersViewModel
import com.example.bellascoffeeapp.ui.theme.BellasTheme
import kotlinx.serialization.Serializable

@Composable
fun Coffee(viewModel : OrdersViewModel){
    val orderItems by viewModel.orderItemList.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getOrders()
    }

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(BellasTheme.colorScheme.background)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp),
        ){
        items(orderItems){ item ->
            OrderItemComposable(item)
        }
    }
}

@Composable
fun OrderItemComposable(item: OrderItem){
    Card (colors = CardDefaults.cardColors(containerColor = BellasTheme.colorScheme.onBackground)){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(100.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            ){
            Column (){
                Text(text = item.name,
                    style = BellasTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = item.price,
                    style = BellasTheme.typography.labelLarge)
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.imageUrl)
                    .build(),
                placeholder = painterResource(R.drawable.bellascoffeelab),
                fallback = painterResource(R.drawable.bellascoffeelab),
                contentDescription = "Image of ${item.name}",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Serializable
object Coffee