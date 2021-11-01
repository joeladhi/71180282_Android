package com.example.pertemuan7_recylerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listContact: ArrayList<Contact>, var context: Context): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    class ContactHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(contact: Contact, context: Context){
            view.findViewById<ImageView>(R.id.imgProfile).setImageResource(contact.profile)
            view.findViewById<TextView>(R.id.txtName).setText(contact.name)
            view.setOnClickListener {
                val intent = Intent(context, ContactDetail::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactHolder(v)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(listContact[position], context)
    }

    override fun getItemCount(): Int {
        return listContact.size
    }
}