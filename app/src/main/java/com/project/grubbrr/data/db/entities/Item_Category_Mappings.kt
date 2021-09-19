package com.project.grubbrr.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull


@Entity(tableName = "item_category_mapping_table")
data class Item_Category_Mappings (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "PCMappingID")
    @NonNull var PCMappingID : Int? = 0,

    @ColumnInfo(name = "ItemID")
    var ItemID : String? = "",

    @ColumnInfo(name = "CategoryID")
    var CategoryID : String? = "",

    @ColumnInfo(name = "DisplayOrder")
    var DisplayOrder : String? = ""


)