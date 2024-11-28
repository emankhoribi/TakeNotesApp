package com.khoribians.takenotesapp.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0 ,
    val title: String,
    val thoughts: String,
    val color: Int,
    val date: String
)
