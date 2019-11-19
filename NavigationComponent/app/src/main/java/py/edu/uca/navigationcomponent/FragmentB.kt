package py.edu.uca.navigationcomponent


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_fragment_b.*
import py.edu.uca.navigationcomponent.adapter.PeliculaAdapter
import py.edu.uca.navigationcomponent.model.Pelicula

class FragmentB : Fragment() {

    private lateinit var listaPeliculasRV: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: PeliculaAdapter
    private val peliculas: MutableList<Pelicula> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_fragment_b, container, false)
        listaPeliculasRV = view.findViewById(R.id.lista_peliculas_rv)

        linearLayoutManager = LinearLayoutManager(requireContext())
        listaPeliculasRV.layoutManager = linearLayoutManager

        adapter = PeliculaAdapter(peliculas as ArrayList<Pelicula>)
        listaPeliculasRV.adapter = adapter

        return view
    }

    override fun onStart() {
        super.onStart()

        if (peliculas.isEmpty()) {
            peliculas.add(Pelicula("Pelicula 1"))
            peliculas.add(Pelicula("Pelicula 2"))
            peliculas.add(Pelicula("Pelicula 3"))
            peliculas.add(Pelicula("Pelicula 4"))
            adapter.notifyItemInserted(peliculas.size - 1)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ir_a_c_button.setOnClickListener {
            val action =
                FragmentBDirections.actionFragmentBToFragmentC("Hola desde el fragment B")
            findNavController().navigate(action)
        }
    }


}
