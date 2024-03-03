package com.yostin.cafetin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        asignarReference()
        replaceFragment(CategoryF())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

    private fun asignarReference(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navCategories -> {
                    replaceFragment(CategoryF())
                    true
                }
                R.id.navCart -> {
                    // Aquí deberías reemplazar con la lógica para cambiar al fragmento del Carrito
                    true
                }
                R.id.navUser -> {
                    replaceFragment(UserPerfil())
                    true
                }
                else -> false
            }
        }
    }
}