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
            peliculas.add(Pelicula("Rambo", "https://www.abc.com.py/resizer/GtvbP4JntC6HaTSdfmHqVqwMxcw=/350x225/smart/arc-anglerfish-arc2-prod-abccolor.s3.amazonaws.com/public/AC34LTXAUFGGTEA57RKOEYKNSU.jpg"))
            peliculas.add(Pelicula("Titanic", "https://s.mxmcdn.net/images-storage/albums5/7/7/4/4/6/1/35164477_350_350.jpg"))
            peliculas.add(Pelicula("The Joker", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvSbT_O3xHe-nCyfGPd8Rhi_AL3if_XYDi_bfDveWcbBqO3xqxEA&s"))
            peliculas.add(Pelicula("Avenger", "https://img-cdn.hipertextual.com/files/2019/03/hipertextual-marvel-2019381704.jpg?strip=all&lossy=1&quality=57&resize=740%2C490&ssl=1"))
            peliculas.add(Pelicula("50 sombras de Grey", "https://www.infobae.com/new-resizer/wKLkJ1_xy7EQ3b3xluYJFr3GLlA=/750x0/filters:quality(100)/arc-anglerfish-arc2-prod-infobae.s3.amazonaws.com/public/3NHY3INMYRBNRHEC2WEVCCASY4"))
            adapter.notifyItemInserted(peliculas.size - 1)
        }
    }


}
