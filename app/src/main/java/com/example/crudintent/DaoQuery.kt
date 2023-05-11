package com.example.crudintent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DaoQuery {

        @Query("SELECT * FROM Persona")
        fun getAll(): List<Persona>

        @Query("SELECT * FROM Persona WHERE id = :id")
        fun getOne(id: Int): Persona

        @Insert
        fun insertAll(personas: Persona)


        @Query("DELETE FROM Persona where id = :id")
        fun delete(id: Int)

        @Query("UPDATE Persona SET nombre = :nombre, apellido = :apellido, edad = :edad WHERE id = :id")
        fun update(id: Int, nombre: String, apellido: String, edad: Int)
}