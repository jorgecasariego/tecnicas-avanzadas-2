package py.edu.uca.navigationcomponent


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_fragment_b.*
import py.edu.uca.navigationcomponent.adapter.PeliculaAdapter
import py.edu.uca.navigationcomponent.adapter.PeliculaInterface
import py.edu.uca.navigationcomponent.model.Pelicula

class FragmentB : Fragment(), PeliculaInterface {

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

        adapter = PeliculaAdapter(peliculas as ArrayList<Pelicula>, this)
        listaPeliculasRV.adapter = adapter

        return view
    }

    override fun onStart() {
        super.onStart()

        if (peliculas.isEmpty()) {
            peliculas.add(Pelicula("Capitan Marvel", "https://as.com/meristation/imagenes/2019/01/03/noticias/1546514335_674507_1546514391_noticia_normal.jpg"))
            peliculas.add(Pelicula("Joker", "https://www.elindependiente.com/wp-content/uploads/2019/10/joker-2019-joaquin-phoenix-clown-5c-1440x808.jpg"))
            peliculas.add(Pelicula("Pelicula 3", "https://1.bp.blogspot.com/-oaAXSrYJu1o/XO8QVVaEbaI/AAAAAAAAGw8/xf209fio3Z4xUp5tAUMO70Ftcr7uBkXkwCLcBGAs/s1600/Aladdin-cartel-pelicula-espan%25CC%2583a.jpg"))
            peliculas.add(Pelicula("Pelicula 4", "https://as01.epimg.net/us/imagenes/2019/04/23/tikitakas/1556048083_533161_1556048763_sumario_normal.jpg"))
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

    override fun peliculaClicked(pelicula: Pelicula) {
        Toast.makeText(context, "Click en la pelicula ${pelicula.nombre}", Toast.LENGTH_LONG).show()
    }


}
