package com.project.grubbrr.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "items_table")
data class Items (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "ItemID")
    @NonNull var ItemID : Int? = 0,

    @ColumnInfo(name = "Name")
    var Name : String? = "",

    @ColumnInfo(name = "FullDescription")
    var FullDescription : String? = "",

    @ColumnInfo(name = "Price")
    var Price : String? = ""
)