package com.project.grubbrr.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.grubbrr.data.db.entities.ScreenSaverMasters


@Dao
interface ScreenSaverMastersDao {

    @Insert
    suspend fun insertData(screenSaverMasters: ScreenSaverMasters)

    @Update
    suspend fun updateData(screenSaverMasters: ScreenSaverMasters)

    @Query("SELECT * FROM screensaver_masters_table")
    fun getAllData(): LiveData<List<ScreenSaverMasters>>

    @Query("DELETE FROM screensaver_masters_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMoreData(screenSaverMasters: ScreenSaverMasters)


}