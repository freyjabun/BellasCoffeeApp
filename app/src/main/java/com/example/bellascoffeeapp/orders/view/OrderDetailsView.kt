package com.example.bellascoffeeapp.orders.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.bellascoffeeapp.R
import com.example.bellascoffeeapp.orders.model.Drink
import com.example.bellascoffeeapp.orders.model.ExtraDto
import com.example.bellascoffeeapp.orders.viewmodel.OrderDetailsViewModel
import com.example.bellascoffeeapp.ui.theme.BellasTheme
import kotlinx.serialization.Serializable

@Composable
fun OrderDetailsView(viewModel: OrderDetailsViewModel){
    val extras by viewModel.extrasList.collectAsState()
    val drink by viewModel.drink.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getDrink()
        viewModel.getExtras()
    }

    Column (Modifier
        .fillMaxSize()
        .background(BellasTheme.colorScheme.background)
        .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        if (drink.isEmpty())
        {
            CircularProgressIndicator()
        }
        else {
            DrinkItem(drink[0])
            if(drink[0].type == "coffee"){
                Extras(extras)
            }
        }
    }
}

@Composable
private fun DrinkItem(drink: Drink){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)){
        AsyncImage(
            modifier = Modifier.height(300.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(drink.imageUrl)
                .build(),
            placeholder = painterResource(R.drawable.bellascoffeelab),
            fallback = painterResource(R.drawable.bellascoffeelab),
            contentDescription = "Image of ${drink.name}"
        )
        Text(drink.name, style = BellasTheme.typography.labelLarge)
        DrinkPrices(drink.sPrice, drink.mPrice, drink.lPrice)
    }
}

@Composable
private fun DrinkPrices(small: Float?, medium: Float?, large: Float?){
    Text("Small: $small DKK")
    Text("Medium: $medium DKK")
    Text("Large: $large DKK")
}

@Composable
private fun Extras(extras: List<ExtraDto>){
    Text("Extras Here")
    Column { extras.forEach{
        ExtrasItem(it)
        }
    }
}

@Composable
private fun ExtrasItem(extra: ExtraDto){
    Card {  }
}


@Serializable
data class OrderDetailsRoute(
    val id: String
)