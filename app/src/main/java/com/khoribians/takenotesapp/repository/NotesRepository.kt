package com.khoribians.takenotesapp.repository

import com.khoribians.takenotesapp.db.TakeNotesDatabase
import com.khoribians.takenotesapp.db.data.Note
import kotlinx.coroutines.flow.Flow

class NotesRepository(private val db: TakeNotesDatabase) {

    fun getNotes() : Flow<List<Note>> = db.NoteDao().getNotes()
}