package com.example.bellascoffeeapp.utils.dependencies

import com.example.bellascoffeeapp.orders.repo.OrdersRepository
import com.example.bellascoffeeapp.orders.repo.OrdersRepositoryImpl
import com.example.bellascoffeeapp.orders.viewmodel.OrdersViewModel
import com.example.bellascoffeeapp.shop.model.ShopItemRepository
import com.example.bellascoffeeapp.shop.model.ShopItemRepositoryImpl
import com.example.bellascoffeeapp.shop.viewmodel.ShopItemViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single <SupabaseClient>{
        createSupabaseClient(
            supabaseUrl = "https://kiymqgbxjbwpyppodggo.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImtpeW1xZ2J4amJ3cHlwcG9kZ2dvIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDEzNDcwODAsImV4cCI6MjA1NjkyMzA4MH0.eK_qVxhrDFOYzYo-BogSNRSGlKkRIzA9oe95PPQE6-k"
        ) {
            install(Postgrest)
        }
    }
    //Shop Items
    single<ShopItemRepository> {
        ShopItemRepositoryImpl(get())
    }

    viewModel {
        ShopItemViewModel(get())
    }

    //Order Items
    single <OrdersRepository>{
        OrdersRepositoryImpl(get())
    }

    viewModel {
        OrdersViewModel(get())
    }

}
