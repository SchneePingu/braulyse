package com.example.braulyse.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.braulyse.model.AlcoholContentViewModel
import com.example.braulyse.ui.theme.BraulyseTheme

@Composable
fun AlcoholContentView(
    alcoholContentViewModel: AlcoholContentViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.size(5.dp))
        AlcoholContentIndicator(
            alcoholContent = alcoholContentViewModel.alcoholContent,
            alcoholContentUncertainty = alcoholContentViewModel.alcoholContentUncertainty,
            maxAlcoholContent = alcoholContentViewModel.maxAlcoholContent
        )
        Spacer(modifier = modifier.size(15.dp))
        AlcoholContentDescription()
        Spacer(modifier = modifier.size(5.dp))
    }
}

@Composable
private fun AlcoholContentIndicator(
    alcoholContent: Double,
    alcoholContentUncertainty: Double,
    maxAlcoholContent: Double,
    modifier: Modifier = Modifier
) {
    fun formatAlcoholContent(alcoholContent: Double): String {
        if (alcoholContent < 1.000) {
            return "%.2f".format(alcoholContent)
        }

        return "%.3g".format(alcoholContent)
    }

    fun formatAlcoholContentUncertainty(alcoholContentUncertainty: Double): String {
        return "(±${formatAlcoholContent(alcoholContentUncertainty)})"
    }

    Box(
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            progress = 1f,
            modifier = modifier.size(integerResource(R.integer.circular_indicator_size).dp),
            strokeWidth = integerResource(R.integer.circular_indicator_stroke_width).dp,
            color = MaterialTheme.colorScheme.surface
        )
        CircularProgressIndicator(
            progress = (alcoholContent / maxAlcoholContent).toFloat(),
            modifier = modifier.size(integerResource(R.integer.circular_indicator_size).dp),
            strokeWidth = integerResource(R.integer.circular_indicator_stroke_width).dp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = formatAlcoholContent(alcoholContent),
                fontSize = integerResource(R.integer.alcohol_content_font_size).sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Text(
                text = formatAlcoholContentUncertainty(alcoholContentUncertainty),
                fontSize = integerResource(R.integer.alcohol_content_uncertainty_font_size).sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
    }
}

@Composable
private fun AlcoholContentDescription() {
    Text(
        text = stringResource(R.string.alcohol_content_label),
        fontSize = integerResource(R.integer.alcohol_content_label_font_size).sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.surfaceTint
    )
    Text(
        text = stringResource(R.string.alcohol_content_unit),
        fontSize = integerResource(R.integer.alcohol_content_unit_font_size).sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.surfaceTint
    )
}

@Preview(name = "LightTheme", showBackground = true)
@Preview(name = "DarkTheme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AlcoholContentViewPreview() {
    val alcoholContentViewModel = AlcoholContentViewModel()
    alcoholContentViewModel.alcoholContent = 7.77
    alcoholContentViewModel.maxAlcoholContent = 11.0

    BraulyseTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            AlcoholContentView(
                alcoholContentViewModel
            )
        }
    }
}