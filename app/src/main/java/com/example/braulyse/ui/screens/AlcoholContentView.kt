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
import com.example.braulyse.ui.theme.BraulyseTheme

@Composable
fun AlcoholContentView(
    alcoholContent: Float,
    maxAlcoholContent: Float,
    modifier: Modifier = Modifier
) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AlcoholContentIndicator(
                alcoholContent = alcoholContent,
                maxAlcoholContent = maxAlcoholContent
            )
            Spacer(modifier = modifier.size(10.dp))
            AlcoholContentDescription()
        }
    }
}

@Composable
private fun AlcoholContentIndicator(
    alcoholContent: Float,
    maxAlcoholContent: Float,
    modifier: Modifier = Modifier
) {
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
            progress = alcoholContent / maxAlcoholContent,
            modifier = modifier.size(integerResource(R.integer.circular_indicator_size).dp),
            strokeWidth = integerResource(R.integer.circular_indicator_stroke_width).dp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = alcoholContent.toString(),
            fontSize = integerResource(R.integer.alcohol_content_label_font_size).sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.surfaceTint
        )
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
    BraulyseTheme {
        AlcoholContentView(
            alcoholContent = 7.77f,
            maxAlcoholContent = 11.0f,
        )
    }
}