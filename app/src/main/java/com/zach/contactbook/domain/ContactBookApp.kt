package com.zach.contactbook.domain

import android.app.Application
import com.example.myapplication.domain.dataBase.ContactBookDB



/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


class ContactBookApp:Application() {


    companion object {
       private lateinit var db: ContactBookDB
        fun getDatabase(): ContactBookDB {
            return db
        }

    }


    override fun onCreate() {
        super.onCreate()
       db = ContactBookDB(this)
    }
}