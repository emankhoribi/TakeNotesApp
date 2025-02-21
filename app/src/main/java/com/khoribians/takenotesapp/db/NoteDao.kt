package com.khoribians.takenotesapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khoribians.takenotesapp.db.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(note: Note): Long

    @Query("SELECT * FROM note WHERE id = :id")
    fun getNote(id: Int): Flow<Note>


    @Query("SELECT * FROM note ")
    fun getNotes(): Flow<MutableList<Note>>

    @Query("SELECT * FROM note WHERE title LIKE :searchQuery OR thoughts LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<MutableList<Note>>

    @Delete
    suspend fun deleteRecord(note: Note): Int
}