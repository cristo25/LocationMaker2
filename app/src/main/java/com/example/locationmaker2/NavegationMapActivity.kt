package com.example.locationmaker2

import android.content.Intent
import android.content.res.loader.ResourcesProvider
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.example.locationmaker2.databinding.ActivityNavegationMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class NavegationMapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map:GoogleMap
    private lateinit var binding: ActivityNavegationMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        binding = ActivityNavegationMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createFragment()
        binding.btnBackActivity.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun createFragment(){
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map)
                as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }
    private fun createMarker(){
        val coordinates = LatLng(20.6721825,-103.3844292)
        val marker = MarkerOptions().position(coordinates).title("Primera Ubicacion")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
            /*
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_visited_marker))
                .anchor(0.0f,1.0f)
            */
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }



}