package com.project.grubbrr.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "item_images_table")
data class ItemImages (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "IImgID")
    @NonNull var IImgID : Int? = 0,

    @ColumnInfo(name = "ImageUrl")
    var ImageUrl : String? = "",

    @ColumnInfo(name = "ItemID")
    var ItemID : String? = ""

)