package com.example.pertemuan6_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_first, container, false)
        val txtSatu = v.findViewById<TextView>(R.id.txtSatu)
        txtSatu.setOnClickListener{
            Toast.makeText(context, "Ini Halaman Satu", Toast.LENGTH_SHORT).show()
        }
        val btnPage2 = v.findViewById<Button>(R.id.btnPage2)
        btnPage2.setOnClickListener {
            val intent = Intent(activity, MainSecond::class.java)
            startActivity(intent)
        }
        return v
    }
}