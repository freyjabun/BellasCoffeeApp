package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.OrderItem
import com.example.bellascoffeeapp.orders.model.OrderItemDTO
import com.example.bellascoffeeapp.orders.model.asDomainModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

class OrdersRepositoryImpl(private val db: SupabaseClient) : OrdersRepository {
    override suspend fun getOrderItems() : List<OrderItem>{
        val res = db.postgrest.from("OrderItem")
            .select().decodeList<OrderItemDTO>()
        return res.map { it.asDomainModel() }
    }
}