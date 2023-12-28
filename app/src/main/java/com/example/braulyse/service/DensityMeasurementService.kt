package com.example.braulyse.service

import com.example.braulyse.model.DensityMeasurement

private const val DEFAULT_INITIAL_DENSITY = 1.050f
private const val DEFAULT_FINAL_DENSITY = 1.010f

private const val MIN_RELATIVE_DENSITY = 1.000f
private const val MAX_RELATIVE_DENSITY = 1.083f
class DensityMeasurementService {
    companion object {
        // Convert relative density [1] to mass fraction [°P] (Degree Plato)
        fun toMassFraction(relativeDensity: Float): Float {
            return 260.4f * (1.0f - 1.0f / relativeDensity)
        }

        fun getDensityMeasurementDefault(): DensityMeasurement {
            return DensityMeasurement(DEFAULT_INITIAL_DENSITY, DEFAULT_FINAL_DENSITY)
        }

        fun getDensityMeasurementLimit(): DensityMeasurement {
            return DensityMeasurement(MAX_RELATIVE_DENSITY, MIN_RELATIVE_DENSITY)
        }
    }
}