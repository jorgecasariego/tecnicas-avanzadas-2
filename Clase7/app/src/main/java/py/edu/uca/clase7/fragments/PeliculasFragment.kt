package py.edu.uca.clase7.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import py.edu.uca.clase7.R
import py.edu.uca.clase7.adapter.PeliculasAdapter
import py.edu.uca.clase7.model.Pelicula

class PeliculasFragment : Fragment() {

    private lateinit var listaPeliculasRv: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: PeliculasAdapter
    private val peliculas: MutableList<Pelicula> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_peliculas, container, false)

        listaPeliculasRv = view.findViewById(R.id.lista_peliculas)

        linearLayoutManager = LinearLayoutManager(requireContext())
        listaPeliculasRv.layoutManager = linearLayoutManager

        adapter = PeliculasAdapter(requireContext(), peliculas as ArrayList<Pelicula>)
        listaPeliculasRv.adapter = adapter

        return view
    }

    override fun onStart() {
        super.onStart()

        if (peliculas.isEmpty()) {
            peliculas.add(Pelicula("Rambo", ""))
            peliculas.add(Pelicula("Titanic", ""))
            peliculas.add(Pelicula("The Joker", ""))
            peliculas.add(Pelicula("Avenger", ""))
            peliculas.add(Pelicula("25 sombras de Grey", ""))
            adapter.notifyItemInserted(peliculas.size - 1)
        }
    }


}
