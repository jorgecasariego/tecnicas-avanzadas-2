package py.edu.uca.navigationcomponent


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import py.edu.uca.navigationcomponent.adapter.PeliculaAdapter
import py.edu.uca.navigationcomponent.adapter.PeliculaInterface
import py.edu.uca.navigationcomponent.model.Pelicula
import py.edu.uca.navigationcomponent.model.PeliculaResult
import py.edu.uca.navigationcomponent.network.PeliculaApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentB : Fragment(), PeliculaInterface {

    private lateinit var listaPeliculasRV: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: PeliculaAdapter
    private val peliculas: MutableList<Pelicula> = mutableListOf()

    // 1. Usando lazy lo que hacemos es inicializar la varaible de imdb recien una vez que se empiece a usar
    // la variable peliculasApi
    private val peliculasApi by lazy {
        PeliculaApi.create()
    }

    // 2. Vamos a crear las variables staticas que en Kotlin podemos hacer utilizando companion object
    companion object {
        private val PAGE = 1
        val LANGUAGE = "en-US"
        val API_KEY = "7ac3ca0156061195fead747e09bd53a1"
        val CATEGORY = "popular"
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        ir_a_c_button.setOnClickListener {
//            val action =
//                FragmentBDirections.actionFragmentBToFragmentC("Hola desde el fragment B")
//            findNavController().navigate(action)
//        }

        obtenerPeliculas()
    }

    private fun obtenerPeliculas() {
        val call = peliculasApi.getPeliculas(CATEGORY, API_KEY, LANGUAGE, PAGE)

        call.enqueue(object : Callback<PeliculaResult>{
            override fun onFailure(call: Call<PeliculaResult>, t: Throwable) {
                Toast.makeText(requireContext(),
                    "Fallo al obtener peliculas",
                    Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<PeliculaResult>,
                response: Response<PeliculaResult>
            ) {
                val peliculasApi = response.body()

                Log.d("TEST", "Cantidad de peliculas es : ${peliculasApi?.total_results}");

                peliculasApi?.results?.forEach {pelicula ->
                    peliculas.add(pelicula)
                }
                adapter.notifyItemInserted(peliculas.size - 1)
            }

        })
    }

    override fun peliculaClicked(pelicula: Pelicula) {

    }


}
