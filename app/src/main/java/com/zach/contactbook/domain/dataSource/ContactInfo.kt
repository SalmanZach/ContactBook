package com.zach.contactbook.domain.dataSource

import androidx.room.ColumnInfo


/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


class ContactInfo{

    @ColumnInfo(name = "contactId")
    var contactId:String=""

    @ColumnInfo(name = "stagingId")
    var stagingId:String=""

    @ColumnInfo(name = "status")
    var status:String=""

    @ColumnInfo(name = "acc_context")
    var context:String=""

    @ColumnInfo(name = "userID")
    var userID:String=""

}
