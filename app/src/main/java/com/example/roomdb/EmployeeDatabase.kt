package com.example.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder

@Database(entities = [EmployeeEntity::class], version = 3)
public abstract class EmployeeDatabase : androidx.room.RoomDatabase() {
    abstract fun EmployeeDao(): EmployeeDao

    //val db= Room.databaseBuilder(applicationContext,RoomData::class.java,"emp_database").build()

    companion object {
        private var instance: EmployeeDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): EmployeeDatabase {
            instance = databaseBuilder(
                ctx.applicationContext,
                EmployeeDatabase::class.java,
                "emp_database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            return instance!!
        }
    }
}