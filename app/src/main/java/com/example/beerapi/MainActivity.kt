package com.example.beerapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.example.beerapi.Adapters.BeerAdapter
import com.example.beerapi.Network.APIInterface
import com.example.beerapi.Network.ResponseBeerModel
import com.example.beerapi.Network.ResponseBeerModelItem
import com.example.beerapi.Network.RetrofitClient
import com.example.beerapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment!!.findNavController()

        val popupMenu = PopupMenu(this,null)
        popupMenu.inflate(R.menu.bottom_nav_menu)
        binding.smoothBar.setupWithNavController(popupMenu.menu,navController)

    }
}