package com.example.braulyse.service

class DensityMeasurementService {
    companion object {
        const val defaultInitialDensity = 1.056
        const val defaultFinalDensity = 1.022

        const val minDensity = 1.000
        const val maxDensity = 1.080

        // Convert relative density [1] to mass fraction [°P] (Degree Plato)
        fun toMassFraction(relativeDensity: Double): Double {
            return 260.4 * (1.0 - 1.0 / relativeDensity)
        }
    }
}