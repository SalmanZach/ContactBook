package com.zach.contactbook.domain.dataBase.entity

import androidx.room.*

/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


@Entity
class Account (
    @PrimaryKey(autoGenerate = false)
    var userID:String,
    var status:Int,
    @ColumnInfo(name = "acc_context")
    var context:String
)