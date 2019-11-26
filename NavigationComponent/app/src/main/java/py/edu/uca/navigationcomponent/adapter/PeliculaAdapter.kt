package py.edu.uca.navigationcomponent.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pelicula_item_row.view.*
import py.edu.uca.navigationcomponent.R
import py.edu.uca.navigationcomponent.model.Pelicula
import py.edu.uca.navigationcomponent.util.inflate

interface PeliculaInterface {
    fun peliculaClicked(pelicula: Pelicula)
}

class PeliculaAdapter(val peliculas: ArrayList<Pelicula>, val listener: PeliculaInterface)
    : RecyclerView.Adapter<PeliculaAdapter.PeliculaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaAdapter.PeliculaHolder {
        val inflatedView = parent.inflate(R.layout.pelicula_item_row, false)
        return PeliculaHolder(inflatedView)
    }

    override fun getItemCount() = peliculas.size

    override fun onBindViewHolder(holder: PeliculaAdapter.PeliculaHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.bindPelicula(pelicula, listener)
    }

    class PeliculaHolder(v: View): RecyclerView.ViewHolder(v){
        private var view: View = v
        private var pelicula: Pelicula? = null

        fun bindPelicula(
            pelicula: Pelicula,
            listener: PeliculaInterface
        ) {
            this.pelicula = pelicula
            view.nombre_pelicula.text = pelicula.nombre
            Picasso.get().load(pelicula.url).into(view.imagen_pelicula)

            view.setOnClickListener { listener.peliculaClicked(pelicula) }
        }

    }

}