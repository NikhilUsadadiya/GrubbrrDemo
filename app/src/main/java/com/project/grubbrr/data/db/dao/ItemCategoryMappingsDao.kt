package com.project.grubbrr.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.grubbrr.data.db.entities.Item_Category_Mappings


@Dao
interface ItemCategoryMappingsDao {

    @Insert
    suspend fun insertData(itemCategoryMappings: Item_Category_Mappings)

    @Update
    suspend fun updateData(itemCategoryMappingsDao: Item_Category_Mappings)

    @Query("SELECT * FROM item_category_mapping_table")
    fun getAllData(): LiveData<List<Item_Category_Mappings>>

    @Query("DELETE FROM item_category_mapping_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMoreData(itemCategoryMappings: Item_Category_Mappings)


}