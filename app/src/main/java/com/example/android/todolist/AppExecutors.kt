package com.example.android.todolist

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors(var diskIO: Executor, var networkIO: Executor, var mainThread: Executor) {
    companion object {
        val LOCK = Object()
        var sInstance: AppExecutors? = null
        fun getInstance() : AppExecutors {
            if (sInstance == null) {
                synchronized(LOCK){
                    sInstance = AppExecutors(Executors.newSingleThreadExecutor(),Executors.newFixedThreadPool(3), MainThreadExecutor())
                }
            }
            return sInstance!!
        }
    }
    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}