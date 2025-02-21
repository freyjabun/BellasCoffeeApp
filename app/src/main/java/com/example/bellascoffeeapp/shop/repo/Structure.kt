package com.example.bellascoffeeapp.shop.repo

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import com.example.bellascoffeeapp.R
import com.example.bellascoffeeapp.utils.composables.ShopItem

@Composable
fun ShopCoffeeBags(){
    LazyRow () {
        item {
            ShopItem(
                icon = R.drawable.finca_la_hermosa,
                itemName = "Finca La Hermosa",
                itemPrice = "175,00",
                soldOut = true,
            )
            ShopItem(
                icon = R.drawable.acacia_core,
                itemName = "Acacia Core",
                itemPrice = "150,00",
                soldOut = false
            )
            ShopItem(
                icon = R.drawable.finca_las_mercedes,
                itemName = "Finca Las Mercedes",
                itemPrice = "175.00",
                soldOut = false
            )
            ShopItem(
                icon = R.drawable.aquiares_estate,
                itemName = "Aquiares Estate",
                itemPrice = "150,00",
                soldOut = true
            )
        }
    }
}