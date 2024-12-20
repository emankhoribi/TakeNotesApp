package com.khoribians.takenotesapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khoribians.takenotesapp.db.data.Note
import com.khoribians.takenotesapp.repository.CreateNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(val repository: CreateNoteRepository) : ViewModel() {


    fun upsertNote(note: Note) {

        viewModelScope.launch {
            try {
                repository.upsert(note)
            } catch (e: Exception) {
                Log.e("CreateNoteViewModel", e.message.toString())
            }
        }
    }

    fun insert(title: String, thoughts: String, color: Int, date: String) {
        val note = Note(title = title, thoughts = thoughts, color = color, date = date)
        upsertNote(note)
    }

    fun update(id: Int, title: String, thoughts: String, color: Int, date: String){
        val note = Note(id= id, title = title, thoughts = thoughts, color = color, date = date)
        upsertNote(note)
    }
}