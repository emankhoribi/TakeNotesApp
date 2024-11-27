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
    suspend fun insert(note: Note): Long

    @Query("SELECT * FROM note WHERE id = :id")
    fun getUser(id: Int): Flow<Note>
}