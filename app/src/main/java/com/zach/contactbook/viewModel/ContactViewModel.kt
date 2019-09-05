package com.zach.contactbook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.zach.contactbook.domain.dataBase.dao.ContactDao
import com.zach.contactbook.domain.dataBase.entity.Account
import com.zach.contactbook.domain.dataBase.entity.Contact
import com.zach.contactbook.domain.dataBase.entity.Extension
import com.zach.contactbook.domain.dataSource.ContactInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


class ContactViewModel(private var contactDao:ContactDao):ViewModel() {


    fun insetContacts(contacts:List<Contact>){

        GlobalScope.launch(Dispatchers.IO) {
           contactDao.insertContacts(contacts)
        }
    }

    fun insetAccounts(accounts:List<Account>){
        GlobalScope.launch(Dispatchers.IO) {
            contactDao.insertAccounts(accounts)
        }
    }

    fun insetExtensions(extensions:List<Extension>){
        GlobalScope.launch(Dispatchers.IO) {
           contactDao.insertExtensions(extensions)
        }
    }

    fun getContactInfoById(contactId:String):LiveData<List<ContactInfo>>{
        val data = MediatorLiveData<List<ContactInfo>>()

        GlobalScope.launch(Dispatchers.IO) {
            val savedData = contactDao.getContactInfoById(contactId)
            GlobalScope.launch(Dispatchers.Main) {
                data.addSource(savedData){
                    data.value = it
                    data.removeSource(savedData)
                }
            }
        }

       return data
    }

}