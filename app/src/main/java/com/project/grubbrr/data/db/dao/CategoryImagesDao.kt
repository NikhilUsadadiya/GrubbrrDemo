package com.project.grubbrr.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.grubbrr.data.db.entities.CategoryImages


@Dao
interface CategoryImagesDao {

    @Insert
    suspend fun insertData(categoryImages: CategoryImages)

    @Update
    suspend fun updateData(categoryImages: CategoryImages)

    @Query("SELECT * FROM category_images_table")
    fun getAllData(): LiveData<List<CategoryImages>>

    @Query("DELETE FROM category_images_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMoreData(categoryImages: CategoryImages)


}