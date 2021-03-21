package com.example.androidsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidsqlite.Adapter.ListPersonAdapter
import com.example.androidsqlite.DBHelper.DBHelper
import com.example.androidsqlite.Model.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.*

class MainActivity : AppCompatActivity() {

    internal lateinit var db:DBHelper
    internal var listPerson:List<Person> = ArrayList<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)

        refreshData()

        btn_add.setOnClickListener{
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.addPerson(person)

            refreshData()
        }
        btn_update.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.updatePerson(person)
            refreshData()
        }
        btn_delete.setOnClickListener{
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.deletePerson(person)
            refreshData()
        }
    }
    private fun refreshData(){
        listPerson = db.allPerson
        val adapter = ListPersonAdapter(this@MainActivity, listPerson, edt_id,edt_name,edt_email)
        list_persons.adapter = adapter
    }
}