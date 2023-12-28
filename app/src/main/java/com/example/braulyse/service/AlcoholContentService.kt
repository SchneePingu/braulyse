package com.example.braulyse.service

import com.example.braulyse.model.DensityMeasurement

private const val BALLING_FACTOR = 0.8192f // [1]
private const val ETHANOL_DENSITY = 0.795f // [g/ml]
private const val EXTRACT_AMOUNT = 2.0665f // [g]
private const val YEAST_CARBONIC_ACID_MASS_FRACTION = 0.010665f // [1]

class AlcoholContentService {
    companion object {
        fun calculateAlcoholContent(measurement: DensityMeasurement): Float {
            val initialMassFraction = DensityMeasurementService
                .toMassFraction(measurement.initialDensity)
            val finalMassFraction = DensityMeasurementService
                .toMassFraction(measurement.finalDensity)
            return ( initialMassFraction - finalMassFraction ) * BALLING_FACTOR /
                    ( (EXTRACT_AMOUNT - YEAST_CARBONIC_ACID_MASS_FRACTION * initialMassFraction)
                            * ETHANOL_DENSITY )
        }
    }
}