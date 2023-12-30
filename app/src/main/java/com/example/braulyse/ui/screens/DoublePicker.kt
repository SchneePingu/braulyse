package com.example.braulyse.ui.screens

import android.content.res.Configuration
import android.view.ContextThemeWrapper
import android.widget.NumberPicker
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.braulyse.R
import com.example.braulyse.ui.theme.BraulyseTheme
import java.text.DecimalFormat
import kotlin.math.roundToInt

@Composable
fun FloatPicker(
    minValue: Double,
    maxValue: Double,
    initialValue: Double,
    onValueChanged: (Double) -> Unit
) {
    val context = LocalContext.current
    val floatPicker = remember {
        NumberPicker(ContextThemeWrapper(context, R.style.FloatPickerStyle))
    }

    val minValueIntRep = getIntRep(minValue)
    val maxValueIntRep = getIntRep(maxValue)
    val initialValueIntRep = getIntRep(initialValue)

    val sortedValues = (minValueIntRep..maxValueIntRep)
        .map { value -> getFloatRep(value) }
        .reversed()

    val floatFormat = DecimalFormat(".000")

    floatPicker.minValue = 0
    floatPicker.maxValue = sortedValues.size - 1
    floatPicker.displayedValues = sortedValues
        .map { value -> floatFormat.format(value) }.toTypedArray()
    floatPicker.wrapSelectorWheel = false
    floatPicker.value = maxValueIntRep - initialValueIntRep

    AndroidView(
        factory = { floatPicker },
        update = {
            it.setOnValueChangedListener { _, _, selectedValue ->
                onValueChanged(sortedValues[selectedValue])
            }
        }
    )
}

private fun getIntRep(value: Double): Int {
    return (value * 500.0).roundToInt()
}

private fun getFloatRep(value: Int): Double {
    return value * 0.002
}

@Preview(name = "LightTheme", showBackground = true)
@Preview(name = "DarkTheme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FloatPickerPreview() {
    BraulyseTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            FloatPicker(1.000, 1.082, 1.056, {})
        }
    }
}