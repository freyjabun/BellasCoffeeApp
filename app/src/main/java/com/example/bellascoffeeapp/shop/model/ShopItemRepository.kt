package com.example.bellascoffeeapp.shop.model

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

interface ShopItemRepository {
    suspend fun getShopItems() : List<ShopItem>
}

class ShopItemRepositoryImpl(private val db : SupabaseClient) : ShopItemRepository{

    override suspend fun getShopItems() : List<ShopItem>{
        val res = db.postgrest.from("shop_item")
            .select().decodeList<ShopItemDTO>()
        return res.map { it.asDomainModel() }
        }
    }
