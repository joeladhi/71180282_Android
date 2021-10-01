package com.example.pertemuan5_activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HasilActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

//        val edtNama = findViewById<EditText>(R.id.edtNama)
//        val btnKirim = findViewById<Button>(R.id.btnKirim)

        val nama = intent.getStringExtra( "nama")

        val txtHasil= findViewById<TextView>(R.id.txtHasil)
        txtHasil.text = "Hallo ${nama}"
    }
}