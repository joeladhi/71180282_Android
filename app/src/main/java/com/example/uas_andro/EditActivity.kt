package com.example.uas_andro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class EditActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null
    private companion object{
        private const val TAG = "Edit_Book_Atribut"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        firestore = FirebaseFirestore.getInstance()

        val edtEditJudul = findViewById<EditText>(R.id.edtEditJudul)
        val edtEditTahun = findViewById<EditText>(R.id.edtEditTahun)
        val edtEditGenre = findViewById<EditText>(R.id.edtEditGenre)
        val btnEditSimpan = findViewById<Button>(R.id.btnEditSimpan)

        btnEditSimpan.setOnClickListener {
            val book = Book(
                edtEditJudul.text.toString(),
                edtEditTahun.text.toString().toInt(),
                edtEditGenre.text.toString()
            )
            firestore?.collection("Book")?.document(book.judul)?.set(book)
                ?.addOnSuccessListener {
                    Log.d(TAG, "onCreate:  Penyimpanan berhasil")
                }?.addOnFailureListener {
                    Log.d(TAG, "onCreate:  Penyimpanan gagal")
                }
        }
    }
}