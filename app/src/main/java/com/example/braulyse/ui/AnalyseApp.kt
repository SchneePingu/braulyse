package com.example.braulyse.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.braulyse.ui.screens.AlcoholContentView
import com.example.braulyse.ui.screens.AnalyseAppTopAppBar
import com.example.braulyse.ui.screens.MeasurementView
import com.example.braulyse.ui.theme.BraulyseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyseApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { AnalyseAppTopAppBar() }
    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AlcoholContentView(alcoholContent = 2.85f, maxAlcoholContent = 11.0f)
                MeasurementView()
            }
        }
    }
}

@Preview(name = "LightTheme", showBackground = true)
@Preview(name = "DarkTheme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnalyseAppPreview() {
    BraulyseTheme {
        AnalyseApp()
    }
}