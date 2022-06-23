package com.example.locationmaker2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locationmaker2.adapter.LocationAdapter
import com.example.locationmaker2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var initActivityVar = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        binding.rvPrincipal.layoutManager = LinearLayoutManager(this)
        binding.rvPrincipal.adapter = LocationAdapter(dataProviderLocation.dataLocationList) { info ->
            onClick(
                info
            )
        }
    }

    fun onClick(locationData: LocationData){
        initActivityVar = true
        if (initActivityVar == true){
            val cardV1 = findViewById<CardView>(R.id.CardView) as CardView
            cardV1.setOnClickListener {
                val intent = Intent(this@MainActivity, NavegationMap::class.java)
                startActivity(intent)
                initActivityVar = false
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem =  menu!!.findItem(binding.svBusquedaPrincipalWidget.id)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}