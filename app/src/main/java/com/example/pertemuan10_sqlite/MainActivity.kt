package com.example.pertemuan10_sqlite

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
        lateinit var db: SQLiteDatabase

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val dbHelper = DatabaseHelper(this)
            db = dbHelper.writableDatabase

            val etNama = findViewById<EditText>(R.id.etNama)
            val etUsia = findViewById<EditText>(R.id.etUsia)
            val btnSimpan = findViewById<Button>(R.id.btnSimpan)
            val btnHapus = findViewById<Button>(R.id.btnHapus)

            btnSimpan.setOnClickListener {
                saveData(etNama.text.toString(), etUsia.text.toString())
            }

            btnHapus.setOnClickListener {
                deleteData(etNama.text.toString(), etUsia.text.toString())
            }

        refreshData()
        }

        fun saveData(nama: String, usia: String){
            val values = ContentValues() {
                put(DatabaseContract.Penduduk.COLUMN_NAME_NAMA, nama)
                put(DatabaseContract.Penduduk.COLUMN_NAME_USIA, usia)
            }
            db.insert(DatabaseContract.Penduduk.TABLE_NAME, null, values)
            refreshData()
        }

        fun deleteData(nama: String, usia: String){
            val selection = "${DatabaseContract.Penduduk.COLUMN_NAME_NAMA} LIKE ? OR "+
                "${DatabaseContract.Penduduk.COLUMN_NAME_USIA} LIKE ?"
            val selectionArgs = arrayOf(nama, usia)
            val deletedRows = db.delete(DatabaseContract.Penduduk.TABLE_NAME, selection, selectionArgs)
        refreshData()
        }

        fun refreshData(){
            val columns = arrayOf(
            BaseColumns._ID,
            DatabaseContract.Penduduk.COLUMN_NAME_NAMA,
            DatabaseContract.Penduduk.COLUMN_NAME_USIA
        )

        val cursor = db.query(
        DatabaseContract.Penduduk.TABLE_NAME,
        columns,
        null,
        null,
        null,
        null,
        null
        )

        var result = ""
//        with(cursor) {
//        while (moveToNext()) {
//        result += "${getString(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_NAMA))}"+
//        "-${getString(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_USIA))}th\n"
//        }
//        }

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        tvHasil.text = result
        }
        }