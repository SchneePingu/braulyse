package com.example.braulyse.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.braulyse.service.DensityMeasurementService

class DensityMeasurementViewModel: ViewModel() {
    var initialDensity: Double by mutableStateOf(0.0)
    var finalDensity: Double by mutableStateOf(0.0)

    init {
        initialDensity = DensityMeasurementService.defaultInitialDensity
        finalDensity = DensityMeasurementService.defaultFinalDensity
    }
}