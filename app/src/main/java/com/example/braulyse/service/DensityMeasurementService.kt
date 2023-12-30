package com.example.braulyse.service

class DensityMeasurementService {
    companion object {
        const val defaultInitialDensity = 1.050
        const val defaultFinalDensity = 1.021

        const val minDensity = 1.000
        const val maxDensity = 1.083

        // Convert relative density [1] to mass fraction [°P] (Degree Plato)
        fun toMassFraction(relativeDensity: Double): Double {
            return 260.4 * (1.0 - 1.0 / relativeDensity)
        }
    }
}