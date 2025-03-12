package com.example.bellascoffeeapp.dependencies

import com.example.bellascoffeeapp.shop.model.ShopItemRepository
import com.example.bellascoffeeapp.shop.model.ShopItemRepositoryImpl
import com.example.bellascoffeeapp.shop.viewmodel.ShopItemViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ShopItemRepository> {
        ShopItemRepositoryImpl()
    }

    viewModel {
        ShopItemViewModel(get())
    }

}
