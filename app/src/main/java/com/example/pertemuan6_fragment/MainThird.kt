package com.example.pertemuan6_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainThird : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FirstFragment>(R.id.fragSlot1)
            add<ThirdFragment>(R.id.fragSlot2)
        }
    }
}