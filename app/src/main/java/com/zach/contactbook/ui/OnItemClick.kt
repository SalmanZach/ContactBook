package com.zach.contactbook.ui

import com.zach.contactbook.domain.dataSource.ContactInfo


/**
 * Created by Salman Zach on 4/8/2019.
 * Email - zach.salmansaifi@gmail.com
 */


interface OnItemClick {
    fun onItemClicked(model :ContactInfo)
}