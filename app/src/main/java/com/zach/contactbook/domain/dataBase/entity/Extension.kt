package com.zach.contactbook.domain.dataBase.entity

import androidx.room.*

/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


@Entity
class Extension (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "phoneContactId")
    var phoneContactId: Int,
    @ColumnInfo(name = "ext_context")
    var context:String
)