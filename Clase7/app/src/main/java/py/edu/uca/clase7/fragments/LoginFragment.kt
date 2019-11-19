package py.edu.uca.clase7.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import py.edu.uca.clase7.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iniciar_sesion_button.setOnClickListener {
            Toast.makeText(context, "Iniciar Sesión", Toast.LENGTH_LONG).show()

            val action = LoginFragmentDirections.actionLoginFragmentToPeliculasFragment()
            findNavController().navigate(action)
        }

        registrarse_button.setOnClickListener {
            Toast.makeText(context, "Registrarse", Toast.LENGTH_LONG).show()
        }

    }


}
