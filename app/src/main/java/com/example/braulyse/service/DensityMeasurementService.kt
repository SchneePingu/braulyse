package com.example.braulyse.service

import com.example.braulyse.model.DensityMeasurement

private const val DEFAULT_INITIAL_DENSITY = 1.050
private const val DEFAULT_FINAL_DENSITY = 1.010

private const val MIN_RELATIVE_DENSITY = 1.000
private const val MAX_RELATIVE_DENSITY = 1.083
class DensityMeasurementService {
    companion object {
        // Convert relative density [1] to mass fraction [°P] (Degree Plato)
        fun toMassFraction(relativeDensity: Double): Double {
            return 260.4 * (1.0 - 1.0 / relativeDensity)
        }

        fun getDensityMeasurementDefault(): DensityMeasurement {
            return DensityMeasurement(DEFAULT_INITIAL_DENSITY, DEFAULT_FINAL_DENSITY)
        }

        fun getDensityMeasurementLimit(): DensityMeasurement {
            return DensityMeasurement(MAX_RELATIVE_DENSITY, MIN_RELATIVE_DENSITY)
        }

        fun getMinDensity(): Double {
            return MIN_RELATIVE_DENSITY
        }

        fun getMaxDensity(): Double {
            return MAX_RELATIVE_DENSITY
        }
    }
}