package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseEmployee::class], version = 1, exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

//    companion object {
//        @Volatile
//        private var INSTANCE: EmployeeDatabase? = null
//
//        fun getDatabase(context: Context): EmployeeDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context,
//                    EmployeeDatabase::class.java,
//                    "words_table"
//                ).fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
}
private lateinit var INSTANCE: EmployeeDatabase


fun getDatabase(context: Context): EmployeeDatabase {
    synchronized(EmployeeDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                EmployeeDatabase::class.java,
                "employees"
            ).build()
        }
    }
    return INSTANCE
}