package com.example.bellascoffeeapp.shop.model

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ShopItemRepository {
    suspend fun getShopItems() : List<ShopItem>
}

class ShopItemRepositoryImpl(private val db : SupabaseClient) : ShopItemRepository{

    override suspend fun getShopItems() : List<ShopItem>{
        val res = db.postgrest.from("ShopItem")
            .select().decodeList<ShopItemDTO>()
        return res.map { it.asDomainModel() }
        }
    }
