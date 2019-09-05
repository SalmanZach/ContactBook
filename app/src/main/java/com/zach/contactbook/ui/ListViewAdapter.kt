package com.zach.contactbook.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.zach.contactbook.R
import com.zach.contactbook.databinding.ItemSearchListBinding
import com.zach.contactbook.domain.dataSource.ContactInfo


/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


class ListViewAdapter(private var list: List<ContactInfo> , private var clicker :OnItemClick) : BaseAdapter() {




    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): ContactInfo {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var rootView =view
            val binding =  DataBindingUtil.inflate<ItemSearchListBinding>(
                LayoutInflater.from(parent.context), R.layout.item_search_list, parent, false
            )

            binding.title.text = list[position].contactId
            binding.title.setOnClickListener {
                clicker.onItemClicked(list[position])
            }
            rootView = binding.root

        return rootView
    }



}