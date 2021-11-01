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

class SecondFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_second, container, false)
        val txtDua = v.findViewById<TextView>(R.id.txtDua)
        txtDua.setOnClickListener{
            Toast.makeText(context, "Ini Halaman Dua", Toast.LENGTH_SHORT).show()
        }
        val btnPage3 = v.findViewById<Button>(R.id.btnPage3)
        btnPage3.setOnClickListener {
            val intent = Intent(activity, MainThird::class.java)
            startActivity(intent)
        }
        return v
    }
}