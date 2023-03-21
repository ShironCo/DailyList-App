package com.example.dayswellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dayswellness.data.Days
import com.example.dayswellness.ui.theme.DaysWellnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaysWellnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessApp()
                }
            }
        }
    }
}


@Composable
fun WellnessApp(){

}

@Composable
fun CardApp(numberTip: Int, days: Days, modifier: Modifier = Modifier){
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Text("Tip: $numberTip",
        style = MaterialTheme.typography.h2, color = MaterialTheme.colors.secondary)
    }

}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaysWellnessTheme {

    }
}