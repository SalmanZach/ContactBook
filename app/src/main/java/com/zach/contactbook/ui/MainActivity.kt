package com.zach.contactbook.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zach.contactbook.R
import com.zach.contactbook.domain.core.BaseActivity
import com.zach.contactbook.databinding.ActivityMainBinding
import com.zach.contactbook.domain.ContactBookApp
import com.zach.contactbook.domain.dataSource.ContactInfo
import com.zach.contactbook.domain.dataSource.DataSource
import com.zach.contactbook.viewModel.ContactViewModel
import com.zach.contactbook.viewModel.ViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


class MainActivity : BaseActivity<ActivityMainBinding>(), OnItemClick {



    override val layoutResId: Int
        get() = R.layout.activity_main
    private lateinit var viewModel: ContactViewModel
    private lateinit var mainBinding: ActivityMainBinding
    private val searchList  = arrayListOf<ContactInfo>()
    private val adapter = ListViewAdapter(searchList,this)


    override fun getToolBar(binding: ActivityMainBinding): Toolbar? {
       return null
     }


    override fun onActivityReady(instance: Bundle?, binding: ActivityMainBinding) {

        // this should be done by dependency injection

        val database = ContactBookApp.getDatabase()
        val viewModelFactory = ViewModelFactory(database.contactDao())
        viewModel = ViewModelProviders.of(this@MainActivity, viewModelFactory)
            .get(ContactViewModel::class.java)

        mainBinding = binding
        // filling database
        viewModel.insetContacts(DataSource.getContacts())
        viewModel.insetExtensions(DataSource.getExtensions())
        viewModel.insetAccounts(DataSource.getAccounts())

        binding.searchView.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
              if (s.toString().isNotEmpty()){
                  search(s.toString())
              }else{
                  clearList()
              }
            }
        })

        mainBinding.listView.adapter = adapter

    }



    private fun search(query:String){
        val value = viewModel.getContactInfoById(query)
        value.observe(this, Observer {
            if (it==null) return@Observer
                searchList.clear()
                searchList.addAll(it)
                adapter.notifyDataSetChanged()
        })
    }


    private fun clearList(){
        searchList.clear()
        adapter.notifyDataSetChanged()
    }


    override fun onItemClicked(model: ContactInfo) {
        clearList()
        mainBinding.searchView.setText("")
        mainBinding.contactId.text = model.contactId
        mainBinding.stagingId.text = model.stagingId
        mainBinding.context.text = model.context
        mainBinding.status.text = model.status
        mainBinding.userId.text = model.userID
    }

}
