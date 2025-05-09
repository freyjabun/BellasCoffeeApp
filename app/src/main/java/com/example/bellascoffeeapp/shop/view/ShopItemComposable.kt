package com.example.bellascoffeeapp.shop.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.bellascoffeeapp.R
import com.example.bellascoffeeapp.shop.model.CoffeeDto
import com.example.bellascoffeeapp.ui.theme.BellasTheme

@Composable
fun ShopItemComposable(item: CoffeeDto) {


    Card(colors = CardDefaults.cardColors(containerColor = BellasTheme.colorScheme.onBackground),
        modifier = Modifier.padding(5.dp)) {
        Column(modifier = Modifier.padding(10.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box (contentAlignment = Alignment.TopEnd){
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.imageUrl)
                        .build(),
                    placeholder = painterResource(R.drawable.bellascoffeelab),
                    contentDescription = "Image of ${item.name} bag",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(400.dp).fillMaxSize()
                        .clip(RoundedCornerShape(10.dp)),
                )
                if (item.inStock == false) {
                    SoldOut()
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = item.originCountry + " " + item.name,
                    style = BellasTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = item.price.toString() + ",00",
                    style = BellasTheme.typography.labelLarge
                )
            }
        }
    }

}

@Composable
private fun SoldOut() {
    Text(
        text = "Sold out",
        style = BellasTheme.typography.body,
        color = Color.White,
        modifier = Modifier
            .offset(y = 15.dp, x = (-28).dp)
            .background(BellasTheme.colorScheme.secondary)
            .padding(5.dp)
    )
}
