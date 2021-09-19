package com.project.grubbrr.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dev.mvvmsampleapp.data.network.responses.AuthResponse
import com.dev.mvvmsampleapp.ui.auth.AuthListener
import com.dev.mvvmsampleapp.ui.auth.AuthViewModel
import com.dev.mvvmsampleapp.ui.auth.AuthViewModelFactory
import com.project.grubbrr.ui.BaseNewActivity
import com.project.grubbrr.R
import com.project.grubbrr.data.AppDatabase
import com.project.grubbrr.data.db.entities.*
import com.project.grubbrr.databinding.ActivityLoginBinding
import com.project.grubbrr.ui.screensaver.ScreenSaverActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class LoginActivity : BaseNewActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()
    private var db: AppDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        db = AppDatabase.invoke(this)
//        val dao: ScreenSaverMastersDao = AppDatabase.invoke(this).screenSaverMastersDao
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this

    }

    override fun onStarted() {
        ShowProgressDialog(this, "Please Wait")
    }

    override suspend fun onSuccess(user: AuthResponse) {
        try {
            hideProgressDialog()
            setItemsData(user)
            setItemImagesData(user)
            setItemCategoryMappingData(user)
            setCategoryMasterData(user)
            setCategoryImagesData(user)
            setScreenSaverData(user)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private suspend fun setCategoryImagesData(user: AuthResponse) {
        db!!.categoryImagesDao.deleteAll()
        for (i in 0 until user.categoryImagesList!!.size) {
            val categoryImagesList = CategoryImages(
                user.categoryImagesList!![i].CImgID,
                user.categoryImagesList!![i].ImageUrl,
                user.categoryImagesList!![i].CategoryID
            )

            db!!.categoryImagesDao.insertData(categoryImagesList)
        }

    }

    private suspend fun setCategoryMasterData(user: AuthResponse) {
        db!!.categoryMastersDao.deleteAll()
        for (i in 0 until user.categoryList!!.size) {
            val categoryList = CategoryMasters(
                user.categoryList!![i].CategoryID,
                user.categoryList!![i].Name,
                user.categoryList!![i].Description
            )

            db!!.categoryMastersDao.insertData(categoryList)
        }

    }

    private suspend fun setItemCategoryMappingData(user: AuthResponse) {
        db!!.itemCategoryMappingsDao.deleteAll()
        for (i in 0 until user.itemcategorymappingsList!!.size) {
            val itemcategorymappingsList = Item_Category_Mappings(
                user.itemcategorymappingsList!![i].PCMappingID,
                user.itemcategorymappingsList!![i].ItemID,
                user.itemcategorymappingsList!![i].CategoryID,
                user.itemcategorymappingsList!![i].DisplayOrder
            )

            db!!.itemCategoryMappingsDao.insertData(itemcategorymappingsList)
        }
    }

    private suspend fun setItemImagesData(user: AuthResponse) {
        db!!.itemsImagesDao.deleteAll()
        for (i in 0 until user.itemImagesList!!.size) {
            val itemImageslist = ItemImages(
                user.itemImagesList!![i].IImgID,
                user.itemImagesList!![i].ImageUrl,
                user.itemImagesList!![i].ItemID
            )

            db!!.itemsImagesDao.insertData(itemImageslist)
        }
    }


    private suspend fun setScreenSaverData(user: AuthResponse) {
        db!!.screenSaverMastersDao.deleteAll()
        for (i in 0 until user.datalist!!.size) {
            val screenSaverMasters = ScreenSaverMasters(
                user.datalist!![i].ScreenSaverID,
                "https://staging.grubbrr.com/" + user.datalist!![i].ImagePath
            )

            db!!.screenSaverMastersDao.insertData(screenSaverMasters)
        }

        Intent(this, ScreenSaverActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }


    private suspend fun setItemsData(user: AuthResponse) {
        db!!.itemsDao.deleteAll()
        for (i in 0 until user.itemsList!!.size) {
            val items = Items(
                user.itemsList!![i].ItemID,
                user.itemsList!![i].Name,
                user.itemsList!![i].FullDescription,
                user.itemsList!![i].Price
            )

            db!!.itemsDao.insertData(items)
        }

    }

    override fun onFailure(message: String) {
        hideProgressDialog()
    }
}
