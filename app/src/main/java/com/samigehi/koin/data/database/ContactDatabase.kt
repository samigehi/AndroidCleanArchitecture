package com.samigehi.koin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samigehi.koin.data.source.local.room.entities.ContactRoomEntity
import com.samigehi.koin.data.source.local.room.dao.ContactDao

@Database(entities = [ContactRoomEntity::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract val contactDao: ContactDao

    companion object {
        const val DATABASE_NAME = "contact_db"
    }
}