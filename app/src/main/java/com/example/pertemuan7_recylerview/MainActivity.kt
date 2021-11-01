package com.example.pertemuan7_recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listContact = arrayListOf<Contact>()
        listContact.add(Contact("jojo", R.mipmap.bts1))
        listContact.add(Contact("yoyo", R.mipmap.bts2))
        listContact.add(Contact("bobo", R.mipmap.bts3))

        val rcyContact = findViewById<RecyclerView>(R.id.rcyContact)
        rcyContact.layoutManager = LinearLayoutManager(this)
        val adapter = ContactAdapter(listContact, this)
        rcyContact.adapter = adapter
    }
}