package com.example.bellascoffeeapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import com.example.bellascoffeeapp.orders.view.Coffee
import com.example.bellascoffeeapp.homepage.view.Home
import com.example.bellascoffeeapp.orders.viewmodel.OrdersViewModel
import com.example.bellascoffeeapp.shop.view.Shop
import com.example.bellascoffeeapp.shop.viewmodel.ShopItemViewModel
import com.example.bellascoffeeapp.utils.navItems
import com.example.bellascoffeeapp.ui.theme.BellasTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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
                    mutableIntStateOf(0)
                }
                val configuration = LocalConfiguration.current

                Scaffold(
                    modifier = Modifier.background(BellasTheme.colorScheme.background)
                        .navigationBarsPadding()
                        .statusBarsPadding(),
                    topBar = {
                        when (configuration.orientation) {
                            Configuration.ORIENTATION_PORTRAIT -> {
                                TopAppBar(
                                    colors = topAppBarColors(
                                        containerColor = BellasTheme.colorScheme.background,
                                        titleContentColor = Color.Black,
                                    ),
                                    title = {
                                        Text(text = "Bella's Coffee App")
                                    }
                                )
                            } else -> {
                                //TODO: NavigationRail or similar behavior
                            }
                        }
                    },
                    bottomBar = {
                        when (configuration.orientation) {
                            Configuration.ORIENTATION_PORTRAIT -> {
                                NavigationBar (
                                    containerColor = BellasTheme.colorScheme.background
                                ){
                                    navItems.forEachIndexed { index, item ->
                                        NavigationBarItem(
                                            colors = NavigationBarItemColors(
                                                selectedIndicatorColor = BellasTheme.colorScheme.bellaBlue,
                                                selectedIconColor = Color.Black,
                                                selectedTextColor = Color.Black,
                                                unselectedIconColor = Color.Black,
                                                unselectedTextColor = Color.Gray,
                                                disabledIconColor = Color.Gray,
                                                disabledTextColor = Color.Gray
                                            ),
                                            selected = selectedItemIndex == index,
                                            onClick = {
                                                selectedItemIndex = index
                                                navController.navigate(item.route)
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
                            } else -> {
                                //TODO: NAVIGATION RAIL, SIDE MENU TYPE BEAT
                            }
                        }

                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Home,
                        Modifier.padding(innerPadding),

                    ){
                        composable<Home> {
                            Home()
                        }
                        composable<Coffee> {
                            val viewModel = getViewModel<OrdersViewModel>()
                            Coffee(viewModel)
                        }
                        composable<Shop> {
                            val viewModel = getViewModel<ShopItemViewModel>()
                            Shop(viewModel)
                        }
                    }
                }
            }
        }
    }
}

