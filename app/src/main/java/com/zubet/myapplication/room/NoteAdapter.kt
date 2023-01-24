package com.zubet.myapplication.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zubet.myapplication.R
import kotlinx.android.synthetic.main.adapter_note.view.*
import java.util.RandomAccess

class NoteAdapter (private val notes: ArrayList<Note>, private val listener: OnAdapterListener)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_note, parent,false)
        )
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener{
            listener.onClick(note)

        }
    }

    class NoteViewHolder (val view: View): RecyclerView.ViewHolder(view)

    fun setData(list: List<Note>) {
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(notes: Note)
    }

}




