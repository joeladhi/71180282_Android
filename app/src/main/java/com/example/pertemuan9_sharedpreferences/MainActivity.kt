package com.example.pertemuan9_sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var sp: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hanya bisa diakses di Activity ini saja
//        sp = getPreferences(MODE_PRIVATE)

        //bisa diakses banyak activity
        sp = getSharedPreferences("myDB", MODE_PRIVATE)

        //ambil data
        val nama = sp?.getString("nama", "no name")

        //simpan data
        sp?.edit()?.putString("nama", "Joel Adhi")?.commit()
    }
}