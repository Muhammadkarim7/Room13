package com.example.room13.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room13.models.MyContact

@Dao
interface Dao {
    @Insert
    fun addContact(myContact: MyContact)

    @Query("select * from mycontact")
    fun getAllContacts():List<MyContact>
}