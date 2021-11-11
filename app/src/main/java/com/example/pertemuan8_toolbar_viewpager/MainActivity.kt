package com.example.pertemuan8_toolbar_viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //memasang Toolbar
        setSupportActionBar(findViewById(R.id.toolbar_default))
        supportActionBar?.setDisplayShowTitleEnabled(false)


        // view Pager
        //instansiasi ViewPager
        val viewPager = findViewById<ViewPager2>(R.id.pager)

        //Memasukkan seluruh fragment ke dalam ArrayList
        val listFragment: ArrayList<Fragment> = arrayListOf(SatuFragment(), DuaFragment(), TigaFragment())

        //instansiasi Adapter untuk ViewPager
        val pagerAdapter = PagerAdapter(this, listFragment)
        viewPager.adapter = pagerAdapter

    }

    class PagerAdapter(val activity: AppCompatActivity, val listFragment: ArrayList<Fragment>) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = listFragment.size

        override fun createFragment(position: Int): Fragment = listFragment.get(position)
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            getMenuInflater().inflate(R.menu.menu, menu)
            return true
            }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        when (item.itemId){
            R.id.menu_search -> {
                //instansiasi ViewPager
                val viewPager = findViewById<ViewPager2>(R.id.pager)

                //Memasukkan seluruh fragment ke dalam ArrayList
                val listFragment: ArrayList<Fragment> = arrayListOf(SatuFragment(), DuaFragment(), TigaFragment())

                //instansiasi Adapter untuk ViewPager
                val pagerAdapter = PagerAdapter(this, listFragment)
                viewPager.adapter = pagerAdapter
                viewPager.setCurrentItem(0)
            }
            R.id.menu_profile -> {
                //instansiasi ViewPager
                val viewPager = findViewById<ViewPager2>(R.id.pager)

                //Memasukkan seluruh fragment ke dalam ArrayList
                val listFragment: ArrayList<Fragment> = arrayListOf(SatuFragment(), DuaFragment(), TigaFragment())

                //instansiasi Adapter untuk ViewPager
                val pagerAdapter = PagerAdapter(this, listFragment)
                viewPager.adapter = pagerAdapter
                viewPager.setCurrentItem(1)
            }
            R.id.menu_settings -> {
                //instansiasi ViewPager
                val viewPager = findViewById<ViewPager2>(R.id.pager)

                //Memasukkan seluruh fragment ke dalam ArrayList
                val listFragment: ArrayList<Fragment> = arrayListOf(SatuFragment(), DuaFragment(), TigaFragment())

                //instansiasi Adapter untuk ViewPager
                val pagerAdapter = PagerAdapter(this, listFragment)
                viewPager.adapter = pagerAdapter
                viewPager.setCurrentItem(2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
