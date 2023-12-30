package com.example.braulyse.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.braulyse.R
import com.example.braulyse.model.DensityMeasurementViewModel
import com.example.braulyse.ui.theme.BraulyseTheme

@Composable
fun DensityView(
    densityMeasurementViewModel: DensityMeasurementViewModel,
    onMeasurementChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    fun onInitialDensityChange(density: Double) {
        densityMeasurementViewModel.initialDensity = density

        if (densityMeasurementViewModel.finalDensity > density) {
            densityMeasurementViewModel.finalDensity = density
        }

        onMeasurementChange()
    }
    
    fun onFinalDensityChange(density: Double) {
        densityMeasurementViewModel.finalDensity = density

        if (densityMeasurementViewModel.initialDensity < density) {
            densityMeasurementViewModel.initialDensity = density
        }

        onMeasurementChange()
    }


    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        DensityControl(
            stringResource(R.string.extract_name_initial),
            stringResource(R.string.extract_description_initial),
            densityMeasurementViewModel.initialDensity,
            {density -> onInitialDensityChange(density)},
            modifier
        )
        DensityControl(
            stringResource(R.string.extract_name_final),
            stringResource(R.string.extract_description_final),
            densityMeasurementViewModel.finalDensity,
            {density -> onFinalDensityChange(density)},
            modifier
        )
    }
}

@Preview(name = "LightTheme", showBackground = true)
@Preview(name = "DarkTheme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DensityViewPreview() {
    BraulyseTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            DensityView(DensityMeasurementViewModel(), {})
        }
    }
}