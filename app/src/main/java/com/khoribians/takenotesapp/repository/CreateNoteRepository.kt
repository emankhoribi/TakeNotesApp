package com.khoribians.takenotesapp.repository

import com.khoribians.takenotesapp.db.TakeNotesDatabase
import com.khoribians.takenotesapp.db.data.Note

class CreateNoteRepository(private val db: TakeNotesDatabase) {

    suspend fun upsert(note: Note): Long = db.NoteDao().upsert(note)
}