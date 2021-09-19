package com.project.grubbrr.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "category_masters_table")
data class CategoryMasters (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "CategoryID")
    @NonNull var CategoryID : Int? = 0,

    @ColumnInfo(name = "Name")
    var Name : String? = "",

    @ColumnInfo(name = "Description")
    var Description : String? = ""
)