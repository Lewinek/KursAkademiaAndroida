package com.example.kursakademiaandroida.features.location.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.kursakademiaandroida.core.base.BaseViewModel
import com.example.kursakademiaandroida.features.location.domain.GetLocationsUseCase
import com.example.kursakademiaandroida.features.location.domain.model.Location
import com.example.kursakademiaandroida.features.location.presentation.model.LocationDisplayable

class LocationViewModel(private val getLocationsUseCase: GetLocationsUseCase) : BaseViewModel() {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also { }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map { LocationDisplayable(it) }
        }
    }

    private fun getLocations(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationsUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}