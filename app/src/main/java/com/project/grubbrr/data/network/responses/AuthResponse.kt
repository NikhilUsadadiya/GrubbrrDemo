package com.dev.mvvmsampleapp.data.network.responses

import androidx.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName
import com.project.grubbrr.data.db.entities.*
import java.util.ArrayList


class AuthResponse : ViewModel() {

    @SerializedName("ScreenSaverMasters")
    var datalist: ArrayList<ScreenSaverMasters>? = null


    @SerializedName("CategoryMasters")
    var categoryList: ArrayList<CategoryMasters>? = null

    @SerializedName("CategoryImages")
    var categoryImagesList: ArrayList<CategoryImages>? = null

    @SerializedName("Items")
    var itemsList: ArrayList<Items>? = null


    @SerializedName("ItemImages")
    var itemImagesList: ArrayList<ItemImages>? = null

    @SerializedName("Item_Category_Mappings")
    var itemcategorymappingsList: ArrayList<Item_Category_Mappings>? = null



}