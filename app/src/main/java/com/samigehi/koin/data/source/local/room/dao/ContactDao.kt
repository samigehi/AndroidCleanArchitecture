package com.samigehi.koin.data.source.local.room.dao

import androidx.room.*
import com.samigehi.koin.data.source.local.room.entities.ContactRoomEntity


@Dao
interface ContactDao {
    @Query("SELECT * FROM tb_contact")
    fun getAll(): List<ContactRoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: ContactRoomEntity) : Long

    @Query("UPDATE tb_contact SET name =:name WHERE id = :id")
    fun update(id: Int, name: String)

    @Query("SELECT * FROM tb_contact WHERE id = :id")
    fun getById(id: Int): ContactRoomEntity?

    @Query("DELETE FROM tb_contact WHERE id = :id")
    fun deleteById(id: Int)

}