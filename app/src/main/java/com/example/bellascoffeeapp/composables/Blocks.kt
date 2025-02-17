package com.example.bellascoffeeapp.composables



import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun TextInputWithButton()
{
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

@Composable
fun ShopItem(@DrawableRes icon: Int, itemName: String, itemPrice: String, soldOut: Boolean)
{
    Column (modifier = Modifier
        .background(BellasTheme.colorScheme.shopBackground)
        .wrapContentWidth()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Box(modifier = Modifier.padding(vertical = 10.dp))
        {
            Image(
                painter = painterResource(icon),
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
            modifier = Modifier.align(Alignment.Start),
            verticalArrangement = Arrangement.spacedBy(5.dp)

        ){
            Text(text = stringResource(R.string.bcl),
                style = BellasTheme.typography.labelBella,
                )
            Text(text = itemName,
                style = BellasTheme.typography.labelLarge)
            Text(text = "$itemPrice kr",
                style = BellasTheme.typography.labelMedium)
        }
    }
}
