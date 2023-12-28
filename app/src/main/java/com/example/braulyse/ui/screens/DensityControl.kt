package com.example.braulyse.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.braulyse.R
import com.example.braulyse.ui.theme.BraulyseTheme


private const val MIN_RELATIVE_DENSITY = 1.000f
private const val MAX_RELATIVE_DENSITY = 1.083f

@Composable
fun DensityControl(
    specimenName: String,
    initialDensity: Float,
    modifier: Modifier = Modifier
) {
    var selectedValue by remember { mutableStateOf(initialDensity) }

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = specimenName,
                fontSize = integerResource(R.integer.extract_name_font_size).sp,
                fontWeight = FontWeight.Bold,
            )
            FloatPicker(
                minValue = MIN_RELATIVE_DENSITY,
                maxValue = MAX_RELATIVE_DENSITY,
                initialValue = initialDensity,
                onValueChanged = { newValue ->
                    selectedValue = newValue
                }
            )
        }
    }
}

@Preview(name = "LightTheme", showBackground = true)
@Preview(name = "DarkTheme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DensityControlPreview() {
    BraulyseTheme {
        DensityControl("Stammwürze", 1.055f)
    }
}