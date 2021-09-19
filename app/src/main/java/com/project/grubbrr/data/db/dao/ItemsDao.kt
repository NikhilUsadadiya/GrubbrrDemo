package com.project.grubbrr.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.grubbrr.data.db.entities.Items


@Dao
interface ItemsDao {

    @Insert
    suspend fun insertData(items: Items)

    @Update
    suspend fun updateData(items: Items)

    @Query("SELECT * FROM items_table")
    fun getAllData(): LiveData<List<Items>>

    @Query("DELETE FROM items_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMoreData(items: Items)


}