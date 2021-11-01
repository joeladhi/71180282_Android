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

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_third, container, false)
        val txtTiga = v.findViewById<TextView>(R.id.txtTiga)
        txtTiga.setOnClickListener{
            Toast.makeText(context, "Ini Halaman Tiga", Toast.LENGTH_SHORT).show()
        }
        val btnPage1 = v.findViewById<Button>(R.id.btnPage1)
        btnPage1.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return v
    }
}