package com.example.bellascoffeeapp.shop.model

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ShopItemRepository {
    suspend fun getShopItems() : List<ShopItem>
}

class ShopItemRepositoryImpl : ShopItemRepository{
    private val db = createSupabaseClient(
        supabaseUrl = "https://kiymqgbxjbwpyppodggo.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImtpeW1xZ2J4amJ3cHlwcG9kZ2dvIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDEzNDcwODAsImV4cCI6MjA1NjkyMzA4MH0.eK_qVxhrDFOYzYo-BogSNRSGlKkRIzA9oe95PPQE6-k"
    ) {
        install(Postgrest)
    }

    override suspend fun getShopItems() : List<ShopItem>{
        val res = db.postgrest.from("ShopItem")
            .select().decodeList<ShopItemDTO>()
        return res.map { it.asDomainModel() }
        }
    }
