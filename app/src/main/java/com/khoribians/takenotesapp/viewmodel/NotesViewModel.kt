package com.khoribians.takenotesapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khoribians.takenotesapp.db.data.Note
import com.khoribians.takenotesapp.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(val repository: NotesRepository) : ViewModel() {
    private val _notesFLow: MutableStateFlow<MutableList<Note>?> = MutableStateFlow(null)
    val notesFLow = _notesFLow


    init {

        viewModelScope.launch {
            try {
                repository.getNotes().collect {
                    _notesFLow.value = it
                }
            } catch (e: Exception) {
                Log.e("RegisterViewModel", e.message.toString())
            }
        }
    }


    fun getSearchNotes(searchQuery: String) {
        viewModelScope.launch {
            try {
                repository.getSearchNotes(searchQuery).collect {
                    _notesFLow.value = it
                }
            } catch (e: Exception) {
                Log.e("RegisterViewModel", e.message.toString())
            }
        }
    }

    fun deleteRecord(note: Note) {
        viewModelScope.launch {
            try {

                repository.deleteRecord(note)


            } catch (e: Exception) {
                Log.e("RegisterViewModel", e.message.toString())
            }
        }
    }
}