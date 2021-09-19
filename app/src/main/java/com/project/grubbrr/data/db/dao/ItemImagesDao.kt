package com.project.grubbrr.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.grubbrr.data.db.entities.ItemImages


@Dao
interface ItemImagesDao {

    @Insert
    suspend fun insertData(itemImages: ItemImages)

    @Update
    suspend fun updateData(itemImages: ItemImages)

    @Query("SELECT * FROM item_images_table")
    fun getAllData(): LiveData<List<ItemImages>>

    @Query("DELETE FROM item_images_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMoreData(itemImages: ItemImages)


}