package com.example.androidsqlite.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.example.androidsqlite.Model.Person
import com.example.androidsqlite.R
import kotlinx.android.synthetic.main.row_layout.view.*

class ListPersonAdapter(internal var activity: Activity,
                        internal var listPerson: List<Person>,
                        internal var edt_id: EditText,
                        internal var edt_name: EditText,
                        internal var edt_email: EditText): BaseAdapter(){

    internal var inflater: LayoutInflater

    init{
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View
        rowView = inflater.inflate(R.layout.row_layout, null)

        rowView.txt_row_id.text = listPerson[position].id.toString()
        rowView.txt_name.text = listPerson[position].name.toString()
        rowView.txt_email.text = listPerson[position].email.toString()

        //event
        rowView.setOnClickListener{
            edt_id.setText(rowView.txt_row_id.text.toString())
            edt_name.setText(rowView.txt_name.text.toString())
            edt_email.setText(rowView.txt_email.text.toString())
        }
        return rowView
    }

    override fun getCount(): Int {
        return listPerson.size
    }

    override fun getItem(position: Int): Any {
        return listPerson[position]
    }

    override fun getItemId(position: Int): Long {
        return listPerson[position].id.toLong()
    }


}