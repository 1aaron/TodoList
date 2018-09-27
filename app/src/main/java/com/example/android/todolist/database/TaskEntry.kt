package com.example.android.todolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "task")
class TaskEntry(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var description: String,
        var priority: Int,
        @ColumnInfo(name = "updated_at")
        var updatedAt: Date)
