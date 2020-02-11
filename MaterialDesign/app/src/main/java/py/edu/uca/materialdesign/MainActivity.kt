package py.edu.uca.materialdesign

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_activity.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(my_toolbar as Toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener(this)

        //cambiarFragment(Fragment1.newInstance())

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> drawer.openDrawer(GravityCompat.START)
        }

        return true
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when(menu.itemId) {
            R.id.menu_opcion1 -> Navigation.findNavController(this, R.id.nav_host).navigate(R.id.fragment1) //cambiarFragment(Fragment1.newInstance())
            R.id.menu_opcion2 -> Navigation.findNavController(this, R.id.nav_host).navigate(R.id.fragment2) //cambiarFragment(Fragment2.newInstance())
            R.id.menu_opcion3 -> Navigation.findNavController(this, R.id.nav_host).navigate(R.id.fragment3) //cambiarFragment(Fragment3.newInstance())
        }


        drawer.closeDrawers()
        return true
    }

    private fun cambiarFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.contenedor, fragment)
//            .addToBackStack(null)
//            .commit()
    }
}
