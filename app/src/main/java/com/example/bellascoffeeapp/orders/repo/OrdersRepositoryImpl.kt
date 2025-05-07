package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.OrderItemDTO
import com.example.bellascoffeeapp.orders.model.OrderItemDetail
import com.example.bellascoffeeapp.orders.model.OrderItemExtra
import com.example.bellascoffeeapp.orders.model.OrderItemSize
import com.example.bellascoffeeapp.orders.model.asDomainModel
import com.example.bellascoffeeapp.orders.model.toDomainModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class OrdersRepositoryImpl(private val db: SupabaseClient) : OrdersRepository {

    override suspend fun getOrderItems(): List<OrderItemDetail> {
        val items = db.postgrest.from("order_item")
            .select().decodeList<OrderItemDTO>()

        return items.map { item ->
            val extras = db.postgrest.from("order_item_extras")
                .select(Columns.list("extras(extra_id, extra_name, extra_type, extra_price)"))
                {
                    filter {
                        eq("order_item_id", item.id)
                    }
                }
                .decodeList<OrderItemExtra>()
                .map { it.extra.toDomainModel() }

            val sizes = db.postgrest.from("order_item_sizes")
                .select(Columns.list("sizes(size_id, size_name, size_price)"))
                {
                    filter {
                        eq("order_item_id", item.id)
                    }
                }
                .decodeList<OrderItemSize>()
                .map { it.sizes.toDomainModel() }

            OrderItemDetail(item = item.asDomainModel(), extras = extras, sizes = sizes)
        }
    }
}