package com.neppplus.pizzaorderapp_20210403.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.neppplus.pizzaorderapp_20210403.R
import com.neppplus.pizzaorderapp_20210403.datas.Store

class StoreAdapter(
        val mContext : Context,
        val resId : Int,
        val mList : ArrayList<Store>) : ArrayAdapter<Store>(mContext, resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {

            tempRow = inflater.inflate(R.layout.store_list_item, null)

        }

        val row = tempRow!!


        return row

    }

}