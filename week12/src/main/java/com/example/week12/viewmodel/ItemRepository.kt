package com.example.week12.viewmodel

import androidx.room.Delete
import com.example.week12.roomDB.ItemDatabase
import com.example.week12.roomDB.ItemEntity

class ItemRepository(private val db : ItemDatabase) {
    val dao = db.getItemDao()

    suspend fun InsertItem(itemEntity: ItemEntity) {            //suspend
        dao.InsertItem((itemEntity))
    }

    suspend fun UpdateItem(itemEntity: ItemEntity) {
        dao.UpdateItem(itemEntity)
    }

    suspend fun DeleteItem(itemEntity: ItemEntity) {
        dao.DeleteItem(itemEntity)
    }

    fun getAllItems() = dao.getAllItems()

}