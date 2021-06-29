package com.example.mvvmapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Persons::class], version = 1, exportSchema = false)
abstract class PersonsDatabase : RoomDatabase() {


    abstract fun wordsDao(): PersonsDao?

    companion object {
        @Volatile
        private var INSTANCE: PersonsDatabase? = null

        fun getDatabase(context: Context): PersonsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    PersonsDatabase::class.java,
                    "persons_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}