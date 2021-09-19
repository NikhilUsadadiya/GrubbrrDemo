package com.project.grubbrr.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.grubbrr.data.db.dao.*
import com.project.grubbrr.data.db.entities.*


@Database(
    entities = [ScreenSaverMasters::class,
    Items::class,
    ItemImages::class,
    Item_Category_Mappings::class,
    CategoryMasters::class,
    CategoryImages::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract val screenSaverMastersDao : ScreenSaverMastersDao
    abstract val itemsDao : ItemsDao
    abstract val itemsImagesDao : ItemImagesDao
    abstract val itemCategoryMappingsDao : ItemCategoryMappingsDao
    abstract val categoryMastersDao : CategoryMastersDao
    abstract val categoryImagesDao : CategoryImagesDao


    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: buildDatabase(
                    context
                ).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).allowMainThreadQueries().build()


    }

}