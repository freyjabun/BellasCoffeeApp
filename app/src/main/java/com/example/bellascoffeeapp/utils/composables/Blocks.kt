package com.example.bellascoffeeapp.utils.composables



import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.bellascoffeeapp.R
import com.example.bellascoffeeapp.ui.theme.BellasTheme


@Preview
@Composable
fun BlocksPreview(){
    BellasTheme {
        ShopItem(
            R.drawable.finca_la_hermosa,
            "Finca La Hermosa",
            "175,00",
            true
        )
    }
}


@Composable
fun ShopItem(@DrawableRes icon: Int, itemName: String, itemPrice: String, soldOut: Boolean)
{
    Column (modifier = Modifier
        .background(BellasTheme.colorScheme.background)
        .border(width = 1.dp, color = Color(231, 230, 229))
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                .padding(vertical = 10.dp)
                    .height(240.dp)
            )
                {
                    AsyncImage(
                        contentScale = ContentScale.Fit,
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(icon)
                            .build(),
                        contentDescription = "Coffee Image",
                    )
                    if (soldOut)
                    {
                        Text(text = "Sold out",
                            style = BellasTheme.typography.body,
                            color = Color.White,
                            modifier = Modifier
                                .offset(y = 10.dp)
                                .background(BellasTheme.colorScheme.secondary)
                                .padding(5.dp)
                                .align(Alignment.TopEnd)
                        )
                    }
                }
            Column (
                modifier = Modifier.align(Alignment.Start)
            ){
            ItemDetails(itemName, itemPrice)
        }
    }
}

@Composable
private fun ItemDetails(itemName: String, itemPrice: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = stringResource(R.string.bcl),
            style = BellasTheme.typography.labelBella,
        )
        Text(
            text = itemName,
            style = BellasTheme.typography.labelLarge
        )
        Text(
            text = "$itemPrice kr",
            style = BellasTheme.typography.labelMedium
        )
    }
}
