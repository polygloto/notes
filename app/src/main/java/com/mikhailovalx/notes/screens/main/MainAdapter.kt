package com.mikhailovalx.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikhailovalx.notes.R
import com.mikhailovalx.notes.models.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainHolder(view: View) : RecyclerView.ViewHolder(view){
        val nameNote: TextView = view.item_note_name
        val textNote: TextView = view.item_note_text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNotes[position].text
        holder.nameNote.text = mListNotes[position].name
    }

    override fun getItemCount(): Int = mListNotes.size

    // starts when the holder appears on the screen
    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener{
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    // starts when the holder disappears from the screen
    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    fun setList(list: List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }
}