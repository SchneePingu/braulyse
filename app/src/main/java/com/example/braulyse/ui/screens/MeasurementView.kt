package com.example.braulyse.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.braulyse.R
import com.example.braulyse.ui.theme.BraulyseTheme

@Composable
fun MeasurementView(
    modifier: Modifier = Modifier
) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MeasurementHeader(modifier)
            DensityView(modifier)
        }
    }
}

@Composable
private fun MeasurementHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.measurement_header),
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = integerResource(R.integer.measurement_header_font_size).sp
        )
        Text(
            text = stringResource(R.string.measurement_description),
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = integerResource(R.integer.measurement_description_font_size).sp
        )
        Spacer(modifier = modifier.size(10.dp))
    }
}

@Composable
private fun DensityView(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DensityControl(stringResource(R.string.extract_name_start), 1.055f, modifier)
        DensityControl(stringResource(R.string.extract_name_end), 1.033f, modifier)
    }
}

@Preview(name = "LightTheme", showBackground = true)
@Preview(name = "DarkTheme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MeasurementViewPreview() {
    BraulyseTheme {
        MeasurementView()
    }
}