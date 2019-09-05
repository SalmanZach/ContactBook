package com.zach.contactbook.domain.dataBase.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


@Entity
class Contact(
    @PrimaryKey(autoGenerate = false)
    var _id: Int,
    var contactId:String,
    var stagingId:String
)