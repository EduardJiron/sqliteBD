package com.example.crudintent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.txtNombre)
        val apellido = findViewById<EditText>(R.id.txtApellido)
        val edad = findViewById<EditText>(R.id.txtEdad)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)
        val idPersonaD = intent.getIntExtra("id", 0)



        val room= Room.databaseBuilder(this, DataBs::class.java, "Persona").allowMainThreadQueries().build()

        val dao= room.daoQueryP()
        if (idPersonaD != 0){
            dao.delete(idPersonaD)
        }

        val updateId= intent.getIntExtra("id2", 0)

           if (updateId != 0){

          val persona=dao.getOne(updateId)
               nombre.setText(persona.nombre)
               apellido.setText(persona.apellido)
               edad.setText(persona.edad.toString()
                )
            }

        val recyclerView: RecyclerView =findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter= PersonaAdacter(dao.getAll())


        btnAgregar.setOnClickListener(){

            dao.insertAll(personas= Persona(nombre = nombre.text.toString(), apellido = apellido.text.toString(), edad = edad.text.toString().toInt()))

            nombre.setText("")
            apellido.setText("")
            edad.setText("")

            recyclerView.adapter= PersonaAdacter(dao.getAll())
        }

        btnEditar.setOnClickListener(){


            dao.update( nombre = nombre.text.toString(), apellido = apellido.text.toString(), edad = edad.text.toString().toInt(), id = updateId)
            nombre.setText("")
            apellido.setText("")
            edad.setText("")

            recyclerView.adapter= PersonaAdacter(dao.getAll())
        }









    }
}