package com.example.android.todolist.database

import android.content.Context
import android.util.Log
import androidx.room.*

@Database(entities = arrayOf(TaskEntry::class),version = 1,exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        var sInstance: AppDatabase? = null
        var LOG_TAG = AppDatabase.javaClass.simpleName
        val LOCK = Object()
        const val DATABASE_NAME = "todolist"

        fun getInstance(context: Context): AppDatabase{

            if (sInstance == null) {
                synchronized(LOCK) {
                    Log.d(LOG_TAG,"Creating Database instance");
                    sInstance = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java, DATABASE_NAME)
                            .build()
                }
            }
            Log.d(LOG_TAG,"GETTING THE DATABSE INSTANCE")
            return sInstance!!
        }
    }
    abstract fun taskDao() : TaskDao
}