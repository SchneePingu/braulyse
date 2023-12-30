package com.example.braulyse.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.braulyse.R
import com.example.braulyse.service.DensityMeasurementService
import com.example.braulyse.ui.theme.BraulyseTheme


@Composable
fun DensityControl(
    specimenName: String,
    specimenDescription: String,
    density: Double,
    onDensityChange: (density: Double) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.size(5.dp))
        FloatPicker(
            minValue = DensityMeasurementService.minDensity,
            maxValue = DensityMeasurementService.maxDensity,
            initialValue = density,
            onValueChanged = onDensityChange,
        )
        Spacer(modifier = modifier.size(20.dp))
        Text(
            text = specimenName,
            fontSize = integerResource(R.integer.extract_name_font_size).sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = specimenDescription,
            fontSize = integerResource(R.integer.extract_description_font_size).sp,
        )
    }
}

@Preview(name = "LightTheme", showBackground = true)
@Preview(name = "DarkTheme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DensityControlPreview() {
    BraulyseTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            DensityControl(
                stringResource(R.string.extract_name_initial),
                stringResource(R.string.extract_description_initial),
                1.055,
                {}
            )
        }
    }
}