package com.example.braulyse.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.braulyse.service.AlcoholContentService
import com.example.braulyse.service.DensityMeasurementService


class AlcoholContentViewModel : ViewModel() {
    var alcoholContent: Double by mutableStateOf(0.0)
    var maxAlcoholContent: Double = 0.0

    init {
        alcoholContent = AlcoholContentService.calculateAlcoholContent(
            DensityMeasurementService.getDensityMeasurementDefault())
        maxAlcoholContent = AlcoholContentService.calculateAlcoholContent(
            DensityMeasurementService.getDensityMeasurementLimit())
    }

    fun updateAlcoholContent(densityMeasurement: DensityMeasurement) {
        alcoholContent = AlcoholContentService.calculateAlcoholContent(densityMeasurement)
    }
}