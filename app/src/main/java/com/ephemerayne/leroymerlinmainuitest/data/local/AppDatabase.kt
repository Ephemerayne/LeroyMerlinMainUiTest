package com.ephemerayne.leroymerlinmainuitest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory

@Database(entities = [ProductCategory::class, Product::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null
        private const val DB_NAME = "app.db"

        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java, DB_NAME
                    ).
                    build()
                }
            }
            return instance!!
        }
    }
    abstract fun appDao(): AppDaoRoomImpl
}