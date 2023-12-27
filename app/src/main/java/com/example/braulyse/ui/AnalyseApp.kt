package com.example.braulyse.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.braulyse.ui.screens.AnalyseAppTopAppBar
import com.example.braulyse.ui.theme.BraulyseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyseApp() {
    Scaffold(
        topBar = { AnalyseAppTopAppBar() }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Alkoholgehalt [Vol.-%]",
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 16.sp
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnalyseAppPreview() {
    BraulyseTheme {
        AnalyseApp()
    }
}