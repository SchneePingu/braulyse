package com.example.braulyse.ui.screens

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.braulyse.R
import com.example.braulyse.ui.theme.BraulyseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyseAppTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        title = {
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = integerResource(R.integer.app_name_font_size).sp
                )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AnalyseAppTopAppBarPreview() {
    BraulyseTheme {
        AnalyseAppTopAppBar()
    }
}