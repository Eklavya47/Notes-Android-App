package com.example.notetakingapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notetakingapp.model.Note

@Dao
interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)
    @Update
    suspend fun updateNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Query("Select * from notes order by id desc")
    fun getAllNotes(): LiveData<List<Note>>
    @Query("Select * from notes where noteTitle like :query or noteBody like :query")
    fun searchNote(query: String?): LiveData<List<Note>>
}