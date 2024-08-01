package edu.msudenver.cs3013.lab04

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng

private const val TAG = "MapsFragment"

class SharedViewModel : ViewModel() {
    private val _location = MutableLiveData<LatLng>()
    val location: LiveData<LatLng> get() = _location

    fun setLocation(latLng: LatLng) {
        Log.d(TAG, "setLocation: $latLng")
        _location.value = latLng
    }

    companion object {
        val instance: SharedViewModel by lazy { SharedViewModel() }
    }
}