package com.example.crudintent

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PersonaAdacter(private val persona:List<Persona>):RecyclerView.Adapter<PersonaAdacter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= View.inflate(parent.context, R.layout.itempersona, null)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItems(persona[position])
    }

    override fun getItemCount(): Int {
     return persona.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindItems(persona: Persona) {
            val textViewNombre=itemView.findViewById(R.id.tvNombre) as TextView
            val textViewApellido=itemView.findViewById(R.id.tvApellido) as TextView
            val textViewEdad=itemView.findViewById(R.id.tvEdad) as TextView
            textViewNombre.text=persona.nombre
            textViewApellido.text=persona.apellido
            textViewEdad.text=persona.edad.toString()
            val btnEliminar=itemView.findViewById(R.id.btnEliminar) as TextView
            val btnEditar=itemView.findViewById(R.id.btnEditar) as TextView

            btnEliminar.setOnClickListener {

                val intent= Intent(itemView.context, MainActivity::class.java)
                intent.putExtra("id", persona.id)
                itemView.context.startActivity(intent)

                Toast.makeText(itemView.context, "Eliminado", Toast.LENGTH_SHORT).show()

    }
            btnEditar.setOnClickListener {
                val intent= Intent(itemView.context, MainActivity::class.java)
                intent.putExtra("id2", persona.id)
                itemView.context.startActivity(intent)
            }
}
    }
}