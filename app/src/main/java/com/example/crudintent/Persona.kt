package com.example.crudintent

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Persona(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "apellido") val apellido: String?,
    @ColumnInfo(name = "edad") val edad: Int?,



    )
