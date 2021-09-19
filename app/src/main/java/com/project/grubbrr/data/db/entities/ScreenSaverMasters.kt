package com.project.grubbrr.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "screensaver_masters_table")
data class ScreenSaverMasters (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "ScreenSaverID")
    @NonNull var ScreenSaverID : Int? = 0,

    @ColumnInfo(name = "ImagePath")
    var ImagePath : String? = ""
)