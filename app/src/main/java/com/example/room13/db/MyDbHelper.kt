package com.example.room13.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room13.models.MyContact

@Database(entities = [MyContact::class], version = 1)
abstract class MyDbHelper : RoomDatabase(){
    abstract fun Dao():Dao

            companion object{
                var instance:MyDbHelper? = null

                @Synchronized
                fun getInstance(context: Context):MyDbHelper{
                    if (instance == null){
                        instance = Room.databaseBuilder(context, MyDbHelper::class.java, "my_contact_db")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build()
                    }
                    return instance!!
                 }
            }
}