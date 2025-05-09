package com.example.bellascoffeeapp.shop.model

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

interface ShopItemRepository {
    suspend fun getShopItems() : List<CoffeeDto>
}

class ShopItemRepositoryImpl(private val db : SupabaseClient) : ShopItemRepository{

    override suspend fun getShopItems() : List<CoffeeDto>{
        val res = db.postgrest.from("coffee")
            .select().decodeList<Coffee>()
        return res.map { it.toDto() }
        }
    }
