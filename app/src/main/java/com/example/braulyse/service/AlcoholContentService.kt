package com.example.braulyse.service

private const val BALLING_FACTOR = 0.8192 // [1]
private const val ETHANOL_DENSITY = 0.795 // [g/ml]
private const val EXTRACT_AMOUNT = 2.0665 // [g]
private const val YEAST_CARBONIC_ACID_MASS_FRACTION = 0.010665 // [1]

private const val ALCOHOL_CONTENT_RELATIVE_UNCERTAINTY = 0.05 // [1]

class AlcoholContentService {
    companion object {
        fun calculateAlcoholContent(initialDensity: Double, finalDensity: Double): Double {
            val initialMassFraction = DensityMeasurementService
                .toMassFraction(initialDensity)
            val finalMassFraction = DensityMeasurementService
                .toMassFraction(finalDensity)
            return ( initialMassFraction - finalMassFraction ) * BALLING_FACTOR /
                    ( (EXTRACT_AMOUNT - YEAST_CARBONIC_ACID_MASS_FRACTION * initialMassFraction)
                            * ETHANOL_DENSITY )
        }

        fun calculateAlcoholContentUncertainty(alcoholContent: Double): Double {
            return alcoholContent * ALCOHOL_CONTENT_RELATIVE_UNCERTAINTY
        }
    }
}