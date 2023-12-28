package com.example.braulyse.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.braulyse.R
import com.example.braulyse.ui.theme.BraulyseTheme

private const val DEFAULT_INITIAL_DENSITY = 1.055f
private const val DEFAULT_FINAL_DENSITY = 1.033f

@Composable
fun DensityView(
    modifier: Modifier = Modifier
) {
    var initialDensity by remember { mutableStateOf(DEFAULT_INITIAL_DENSITY) }
    var finalDensity by remember { mutableStateOf(DEFAULT_FINAL_DENSITY) }

    fun onInitialDensityChange(density: Float) {
        initialDensity = density

        if (finalDensity > density) {
            finalDensity = density
        }
    }
    
    fun onFinalDensityChange(density: Float) {
        finalDensity = density

        if (initialDensity < density) {
            initialDensity = density
        }
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        DensityControl(
            stringResource(R.string.extract_name_initial),
            stringResource(R.string.extract_description_initial),
            initialDensity,
            {density -> onInitialDensityChange(density)},
            modifier
        )
        DensityControl(
            stringResource(R.string.extract_name_final),
            stringResource(R.string.extract_description_final),
            finalDensity,
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
            DensityView()
        }
    }
}