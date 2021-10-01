package com.example.pertemuan5_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val edtPass = findViewById<EditText>(R.id.edtPass)
        val wrongPass = findViewById<TextView>(R.id.wrongPass)

        val pass = "12345"

        btnKirim.setOnClickListener {
            if(edtPass.text.toString() == pass){
                val intent = Intent( this, HasilActivity::class.java)
                intent.putExtra("nama", edtNama.text.toString())
                startActivity(intent)
            }
            else{
                wrongPass.text = "Password anda salah, coba lagi bro"
            }
        }
    }
}