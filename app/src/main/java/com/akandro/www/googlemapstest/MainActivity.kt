package com.akandro.www.googlemapstest

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var frag:SupportMapFragment = supportFragmentManager.
                findFragmentById(R.id.frag1) as SupportMapFragment

        frag.getMapAsync(object : OnMapReadyCallback {
            override fun onMapReady(p0: GoogleMap?) {



                var  IManager = getSystemService(Context.LOCATION_SERVICE)
                        as LocationManager

                IManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        1000,1.toFloat(), object : LocationListener {
                    override fun onProviderEnabled(l: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderDisabled(l: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onStatusChanged(l: String?, p1: Int, p2: Bundle?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onLocationChanged(l: Location?) {

                        var ltude1 = l!!.latitude
                        var  logitude2 = l!!.longitude

                        var options = MarkerOptions( )
                        options.position(LatLng(ltude1,logitude2)).title("You Are Here")




                        p0!!.addMarker(options).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bikegprr))

                     p0!!.animateCamera(CameraUpdateFactory.newLatLngZoom(
                             LatLng(ltude1,logitude2),15f))




                    }
                })





            }





        })//end map











    }
}
