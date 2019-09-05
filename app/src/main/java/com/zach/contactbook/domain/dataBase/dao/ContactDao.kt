package com.zach.contactbook.domain.dataBase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zach.contactbook.domain.dataBase.entity.Account
import com.zach.contactbook.domain.dataBase.entity.Contact
import com.zach.contactbook.domain.dataBase.entity.Extension
import com.zach.contactbook.domain.dataSource.ContactInfo

/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


@Dao
interface ContactDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContacts(contacts: List<Contact>):List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAccounts(contacts: List<Account>):List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExtensions(contacts: List<Extension>):List<Long>


    @Query("SELECT c.contactId ,c.stagingId,a.acc_context,a.status,a.userID FROM contact as c inner join  extension as e on e.phoneContactId = c._id inner join  account as a on a.acc_context = e.ext_context WHERE c.contactId LIKE '%'||:contactId||'%'")
    fun getContactInfoById(contactId:String): LiveData<List<ContactInfo>>
}