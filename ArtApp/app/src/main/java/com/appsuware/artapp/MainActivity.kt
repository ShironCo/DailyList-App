package com.appsuware.artapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsuware.artapp.ui.theme.ArtAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtistPresentation()
                }
            }
        }
    }
}

@Composable
fun ArtistPresentation() {
    var artNumber by remember {
        mutableStateOf(1)
    }
    val imgArt: Int
    val authorArt: Int
    val ageArt: Int
    val nameArt: Int
    when(artNumber){
        1 -> {
            imgArt = R.drawable.image_art2
            authorArt = R.string.author1
            ageArt = R.string.age_art1
            nameArt = R.string.name_art1
        }
        2 -> {
            imgArt = R.drawable.image_art1
            authorArt = R.string.author2
            ageArt = R.string.age_art2
            nameArt = R.string.name_art2
        }
        else -> {
            imgArt = R.drawable.image_art3
            authorArt = R.string.author3
            ageArt = R.string.age_art3
            nameArt = R.string.name_art3
        }
    }

    Column(modifier = Modifier
        .padding(horizontal = 20.dp).padding(bottom = 90.dp)
        .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
            elevation = 20.dp
        ) {
            Image(painter = painterResource(imgArt), contentDescription = "Gioconda", Modifier.padding(20.dp))
        }
        Spacer(modifier = Modifier.height(60.dp))
        Surface(elevation = 10.dp, modifier = Modifier
            .fillMaxHeight()
            .wrapContentHeight(Alignment.Bottom)) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(nameArt), fontSize = 40.sp, fontWeight = FontWeight.Light)
                Row{
                    Text(text = stringResource(authorArt), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text =  "("+stringResource(ageArt)+")", fontSize = 20.sp)
                }
            }
        }
    }
    Row (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .wrapContentHeight(Alignment.Bottom)
        .padding(
            horizontal = 30.dp, vertical = 20.dp
        )){
        val context = LocalContext.current
        Button(onClick = {
            when(artNumber){
                1 -> artNumber = 3
                in 2..3 -> artNumber--
                else -> artNumber = 3
            }
            Toast.makeText(context, "$artNumber", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.weight(5f)
        ) {
            Text(text = stringResource(R.string.previous_button))
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(onClick = {
            when(artNumber){
               in 1..2 -> artNumber++
                else -> artNumber = 1
            }
            Toast.makeText(context, "$artNumber", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.weight(5f)
        ) {
            Text(text = stringResource(R.string.next_button))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtAppTheme {
        ArtistPresentation()
    }
}