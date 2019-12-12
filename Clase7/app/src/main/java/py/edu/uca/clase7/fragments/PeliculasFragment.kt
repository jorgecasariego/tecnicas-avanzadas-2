package py.edu.uca.clase7.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import py.edu.uca.clase7.R
import py.edu.uca.clase7.adapter.PeliculasAdapter
import py.edu.uca.clase7.model.Pelicula
import py.edu.uca.clase7.model.PeliculaResult
import py.edu.uca.clase7.network.PeliculasApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasFragment : Fragment() {

    private lateinit var listaPeliculasRv: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: PeliculasAdapter
    private var peliculas: MutableList<Pelicula> = mutableListOf()

    private val peliculasApi by lazy {
        PeliculasApi.create()
    }

    companion object {
        val PAGE = 1
        val LANGUAGE = "en-US"
        val API_KEY = "7ac3ca0156061195fead747e09bd53a1"
        val CATEGORY = "popular"
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        obtenerPeliculas()
    }

    private fun obtenerPeliculas() {
        val call = peliculasApi.getPeliculas(CATEGORY, API_KEY, LANGUAGE, PAGE)

        call.enqueue(object : Callback<PeliculaResult> {
            override fun onFailure(call: Call<PeliculaResult>, t: Throwable) {
                Toast.makeText(requireContext(), "Hubo un error al obtener la pelicula", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<PeliculaResult>,
                response: Response<PeliculaResult>
            ) {
                val misPeliculas = response.body()

//                Log.d("TEST", "Peliculas desde el servidor: ${misPeliculas?.total_results}")

//                misPeliculas?.results?.forEach { pelicula ->
//                    peliculas.add(pelicula)
//                }
                misPeliculas?.results?.let { peliculas.addAll(it) }
                adapter.notifyItemInserted(peliculas.size - 1)
            }

        })
    }

}
