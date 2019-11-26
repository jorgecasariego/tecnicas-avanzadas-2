package py.edu.uca.clase7.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pelicula_item_row.view.*
import py.edu.uca.clase7.R
import py.edu.uca.clase7.model.Pelicula

class PeliculasAdapter (val context: Context, val peliculas: ArrayList<Pelicula>
): RecyclerView.Adapter<PeliculasAdapter.PeliculaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaHolder {
        val view =
            LayoutInflater
                .from(context).inflate(R.layout.pelicula_item_row, parent, false)

        return PeliculaHolder(view)
    }

    override fun getItemCount() = peliculas.size

    override fun onBindViewHolder(holder: PeliculaHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.bindPelicula(pelicula)
    }

    class PeliculaHolder(val v: View): RecyclerView.ViewHolder(v) {
        fun bindPelicula(pelicula: Pelicula) {
            v.nombre_pelicula.text = pelicula.nombre
        }
    }
}