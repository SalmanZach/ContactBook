package com.example.myapplication.domain.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zach.contactbook.domain.dataBase.dao.ContactDao
import com.zach.contactbook.domain.dataBase.entity.Account
import com.zach.contactbook.domain.dataBase.entity.Contact
import com.zach.contactbook.domain.dataBase.entity.Extension

/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


@Database(
    entities = [Contact::class,Extension::class,Account::class],version = 1)
abstract class ContactBookDB : RoomDatabase() {

    abstract fun contactDao(): ContactDao


    companion object {
        @Volatile
        private var instance: ContactBookDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ContactBookDB::class.java, "contactBook.db"
            ).build()
    }
}