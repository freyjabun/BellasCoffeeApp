package com.example.bellascoffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import com.example.bellascoffeeapp.composables.ShopItem
import com.example.bellascoffeeapp.model.dataclass.BottomNavigationItem
import com.example.bellascoffeeapp.model.dataclass.navItems
import com.example.bellascoffeeapp.ui.theme.BellasTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BellasTheme {
                setSingletonImageLoaderFactory { context ->
                    ImageLoader.Builder(context)
                        .crossfade(true)
                        .build()
                }
                val navController = rememberNavController()
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                NavHost(
                    navController = navController,
                    startDestination = HomeScreen
                ){
                    composable<HomeScreen> {
                        ShopCoffeeBags()
                    }
                }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = BellasTheme.colorScheme.background,
                                titleContentColor = Color.Black,
                            ),
                            title = {
                                Text("Bella's Coffee Lab")
                            }
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            navItems.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItemIndex == index,
                                    onClick = {
                                        selectedItemIndex = index
                                        navController.navigate(item.title)
                                    },
                                    label = {
                                        Text(text = item.title)
                                    },
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                if(item.badgeCount != null) {
                                                    Badge {
                                                        Text(text = item.badgeCount.toString())
                                                    }
                                                } else if (item.hasNews) {
                                                    Badge()
                                                }
                                            }
                                        ){
                                            Icon(imageVector = if (index == selectedItemIndex){
                                                item.selectedIcon
                                            }else item.unselectedIcon,
                                                contentDescription = item.title)
                                        }
                                    }
                                ) }
                        }
                    }
                ) { innerPadding ->
                    Column (modifier = Modifier
                        .padding(innerPadding)
                        .background(BellasTheme.colorScheme.background)
                        .verticalScroll(rememberScrollState())){

                        ShopCoffeeBags()
                        HorizontalDivider(
                            Modifier.padding(10.dp)
                        )

                        ShopCoffeeBags()
                        HorizontalDivider(
                            Modifier.padding(10.dp)
                        )
                        ShopCoffeeBags()
                    }
                }
            }
        }
    }
}

@Serializable
object HomeScreen

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

