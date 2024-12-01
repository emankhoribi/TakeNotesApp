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
    private val _notesFLow: MutableStateFlow<List<Note>?> = MutableStateFlow(null)
    val notesFLow = _notesFLow

    fun getNotes() {

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
}