package com.project.grubbrr.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "category_images_table")
data class CategoryImages (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "CImgID")
    @NonNull var CImgID : Int? = 0,

    @ColumnInfo(name = "ImageUrl")
    var ImageUrl : String? = "",

    @ColumnInfo(name = "CategoryID")
    var CategoryID : String? = ""
)