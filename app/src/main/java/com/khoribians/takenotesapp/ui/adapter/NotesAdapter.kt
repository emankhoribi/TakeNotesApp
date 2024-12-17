package com.khoribians.takenotesapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khoribians.takenotesapp.databinding.HolderNoteBinding
import com.khoribians.takenotesapp.db.data.Note

class NotesAdapter(private val listener: RecyclerViewEvent) :
    ListAdapter<Note, NotesAdapter.ViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            HolderNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private val itemBinding: HolderNoteBinding) :
        RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {
        fun bind(note: Note) {
            itemBinding.titleNoteTv.text = note.title
            itemBinding.thoughtsNoteTv.text = note.thoughts
            itemBinding.cnstLayout.setBackgroundColor(note.color)
            itemBinding.dateTv.text = note.date
        }

        init {
            itemBinding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(getItem(position))
            }
        }

    }


    class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(
            oldItem: Note,
            newItem: Note
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Note,
            newItem: Note
        ): Boolean {
            return oldItem == newItem
        }
    }

    interface RecyclerViewEvent {
        fun onItemClick(note: Note)
    }
}