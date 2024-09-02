package com.example.batteryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.batteryapp.ui.theme.BatteryAppTheme
import com.example.batteryapp.ui.viewmodel.BatteryViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatteryAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BatteryStatusScreen()
                }
            }
        }
    }
}

@Composable
fun BatteryStatusScreen(viewModel: BatteryViewModel = viewModel()) {
    val isBatteryHigh by viewModel.isBatteryHigh.observeAsState(true)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val imageRes = if (isBatteryHigh) {
            painterResource(id = R.drawable.battery_full)
        } else {
            painterResource(id = R.drawable.battery_low)
        }
        Image(painter = imageRes, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BatteryAppTheme {
        BatteryStatusScreen()
    }
}