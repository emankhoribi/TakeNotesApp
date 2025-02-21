package com.khoribians.takenotesapp.repository

import com.khoribians.takenotesapp.db.TakeNotesDatabase
import com.khoribians.takenotesapp.db.data.Note
import kotlinx.coroutines.flow.Flow

class NotesRepository(private val db: TakeNotesDatabase) {

    fun getNotes() : Flow<MutableList<Note>> = db.NoteDao().getNotes()
    fun getSearchNotes(searchQuery: String) : Flow<MutableList<Note>> = db.NoteDao().searchDatabase(searchQuery)
    suspend fun deleteRecord(note: Note) : Int = db.NoteDao().deleteRecord(note)
}