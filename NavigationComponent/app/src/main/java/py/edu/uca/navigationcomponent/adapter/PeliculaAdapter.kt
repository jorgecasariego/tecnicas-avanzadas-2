package py.edu.uca.navigationcomponent.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pelicula_item_row.view.*
import py.edu.uca.navigationcomponent.R
import py.edu.uca.navigationcomponent.model.Pelicula
import py.edu.uca.navigationcomponent.util.inflate

class PeliculaAdapter(val peliculas: ArrayList<Pelicula>) : RecyclerView.Adapter<PeliculaAdapter.PeliculaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaAdapter.PeliculaHolder {
        val inflatedView = parent.inflate(R.layout.pelicula_item_row, false)
        return PeliculaHolder(inflatedView)
    }

    override fun getItemCount() = peliculas.size

    override fun onBindViewHolder(holder: PeliculaAdapter.PeliculaHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.bindPelicula(pelicula)
    }

    class PeliculaHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var pelicula: Pelicula? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            Log.d("TEST", "Click en pelicula")
        }

        companion object {
            private val PELICULA_KEY = "PELICULA_KEY"
        }

        fun bindPelicula(pelicula: Pelicula) {
            this.pelicula = pelicula
            view.nombre_pelicula.text = pelicula.nombre
        }

    }

}