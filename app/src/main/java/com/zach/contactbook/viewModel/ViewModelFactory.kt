package com.zach.contactbook.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zach.contactbook.domain.dataBase.dao.ContactDao

/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */

class ViewModelFactory(
    private val contactDao: ContactDao
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(ContactViewModel::class.java) ->
                    ContactViewModel(contactDao)
                else ->
                    error("Invalid View Model class")
            }
        } as T
}