package com.project.grubbrr.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.grubbrr.data.db.entities.CategoryMasters


@Dao
interface CategoryMastersDao {

    @Insert
    suspend fun insertData(categoryMasters: CategoryMasters)

    @Update
    suspend fun updateData(categoryMasters: CategoryMasters)

    @Query("SELECT * FROM category_masters_table")
    fun getAllData(): LiveData<List<CategoryMasters>>

    @Query("DELETE FROM category_masters_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMoreData(categoryMasters: CategoryMasters)


}