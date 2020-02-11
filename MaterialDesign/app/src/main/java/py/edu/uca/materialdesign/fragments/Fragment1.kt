package py.edu.uca.materialdesign.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_frament1.*
import py.edu.uca.materialdesign.R

class Fragment1 : Fragment() {

    lateinit var buttonIrFragment11: Button

    companion object {
        fun newInstance()= Fragment1()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_frament1, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ir_frament11.setOnClickListener {
            findNavController().navigate(R.id.fragment11)
        }
    }

}
