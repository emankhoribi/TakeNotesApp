package com.khoribians.takenotesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khoribians.takenotesapp.db.data.Note


@Database(entities = [Note::class], version = 1)
abstract class TakeNotesDatabase : RoomDatabase(){
    abstract fun NoteDao(): NoteDao
}