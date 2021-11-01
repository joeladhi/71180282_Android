package com.example.pertemuan7_recylerview

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_contact)
        findViewById<TextView>(R.id.txtName)
        findViewById<TextView>(R.id.txtNumber)
        }
    }