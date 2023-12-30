package com.example.braulyse.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.braulyse.service.AlcoholContentService
import com.example.braulyse.service.DensityMeasurementService


class AlcoholContentViewModel : ViewModel() {
    var alcoholContent: Double by mutableStateOf(0.0)
    var alcoholContentUncertainty: Double by mutableStateOf(0.0)
    var maxAlcoholContent: Double by mutableStateOf(0.0)
    init {
        updateModel(
            DensityMeasurementService.defaultInitialDensity,
            DensityMeasurementService.defaultFinalDensity
        )

        maxAlcoholContent = AlcoholContentService.calculateAlcoholContent(
            DensityMeasurementService.maxDensity,
            DensityMeasurementService.minDensity
        )
    }

    fun updateModel(initialDensity: Double, finalDensity: Double) {
        alcoholContent = AlcoholContentService.calculateAlcoholContent(
            initialDensity,
            finalDensity
        )

        alcoholContentUncertainty = AlcoholContentService
            .calculateAlcoholContentUncertainty(alcoholContent)
    }
}