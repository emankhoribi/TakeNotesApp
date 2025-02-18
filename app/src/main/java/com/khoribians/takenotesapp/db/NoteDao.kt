package com.khoribians.takenotesapp.db

import androidx.room.Dao
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
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE title LIKE :searchQuery OR thoughts LIKE :searchQuery")
    // and then search query will be passed through
    // the perimeter of this function
    // and then function will return the flow of list of person
    fun searchDatabase(searchQuery: String): Flow<List<Note>>
}