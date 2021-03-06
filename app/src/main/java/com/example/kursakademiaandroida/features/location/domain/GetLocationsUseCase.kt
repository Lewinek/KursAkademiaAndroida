package com.example.kursakademiaandroida.features.location.domain

import com.example.kursakademiaandroida.core.base.UseCase
import com.example.kursakademiaandroida.features.location.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}