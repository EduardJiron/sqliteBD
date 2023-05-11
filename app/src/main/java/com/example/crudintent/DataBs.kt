package com.example.crudintent

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Persona::class], version = 1)

abstract class DataBs: RoomDatabase() {
    abstract fun daoQueryP():DaoQuery

}
