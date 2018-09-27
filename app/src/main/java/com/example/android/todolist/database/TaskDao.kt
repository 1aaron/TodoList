package com.example.android.todolist.database

import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM task ORDER BY priority")
    fun loadAllTasks() : List<TaskEntry>

    @Insert
    fun insertTask(task: TaskEntry)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(task: TaskEntry)

    @Delete
    fun deleteTask(task: TaskEntry)
}