package com.example.uas_andro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class BookActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null
    private companion object{
        private const val TAG = "Book_Atribut"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        firestore = FirebaseFirestore.getInstance()

        val edtJudul = findViewById<EditText>(R.id.edtJudul)
        val edtTahun = findViewById<EditText>(R.id.edtTahun)
        val edtGenre = findViewById<EditText>(R.id.edtGenre)
        val btnSave = findViewById<Button>(R.id.btnSimpan)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnPerpus = findViewById<Button>(R.id.btnPerpus)
        val txtSearch = findViewById<TextView>(R.id.txtSearch)

        btnSave.setOnClickListener{
            val book = Book(edtJudul.text.toString(), edtTahun.text.toString().toInt() , edtGenre.text.toString())
            firestore?.collection("Book")?.document(book.judul)?.set(book)
                ?.addOnSuccessListener {
                    Log.d(TAG, "onCreate: Penyimpanan berhasil")
                }?.addOnFailureListener{
                    Log.d(TAG, "onCreate: Penyimpanan Gagal")
                }
        }

        btnPerpus.setOnClickListener{
            firestore?.collection("Book")?.get()
                ?.addOnSuccessListener { documents ->
                    for (document in documents) {
                        var output = ""
                        for (document in documents) {
                            output += "\n${document["judul"]}"
                        }
                        txtSearch.setText(output)
                    }
                }
        }

        btnSearch.setOnClickListener{
            firestore?.collection("Book")?.document(edtJudul.text.toString())?.get()!!
                .addOnSuccessListener { documents ->
                    txtSearch.setText(documents["judul"].toString())
                }
        }

        btnDelete.setOnClickListener{
            firestore?.collection("Book")?.document(edtJudul.text.toString())?.delete()!!
                .addOnSuccessListener { Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show() }
        }

        btnEdit.setOnClickListener{
            firestore?.collection("Book")?.document(edtJudul.text.toString())?.get()!!
                .addOnSuccessListener { documents ->
                    txtSearch.setOnClickListener {
                        val intent = Intent(this, EditActivity::class.java)
                        startActivity(intent)
                    }
                }
        }

    }
}