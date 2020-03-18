package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(TeamEntity::class), version = 1, exportSchema = false)
public abstract class TeamDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDAO

    public companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        var INSTANCE: TeamDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
        ): TeamDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TeamDatabase::class.java,
                    "my_teams_table"
                ).addCallback(TeamDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}