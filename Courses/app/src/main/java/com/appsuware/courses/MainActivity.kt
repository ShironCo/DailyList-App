package com.appsuware.courses

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.contentcapture.DataRemovalRequest
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appsuware.courses.data.DataSource
import com.appsuware.courses.data.Topic
import com.appsuware.courses.ui.theme.CoursesTheme
import com.appsuware.courses.ui.theme.Typography
import java.util.Vector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    color = MaterialTheme.colors.background
                ) {
                    TopicGrid()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoursesApp(modifier: Modifier = Modifier
    .fillMaxSize()
    .padding(5.dp)){
    CoursesCard(Topic(R.string.architecture, 12, R.drawable.image5))
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CoursesCard(topic: Topic, modifier: Modifier = Modifier){
    Card(elevation = 10.dp, onClick = {

    }) {
        Row(){
            Image(painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringRes),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop

            )
            Column() {
                Text(text = stringResource(topic.stringRes),
                    style = Typography.body2,
                    modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(R.drawable.ic_grain), contentDescription = null,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(15.dp))
                    Text(text = topic.cantCourses.toString(), style = Typography.caption)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(DataSource.topics.size) { topic ->
            CoursesCard(DataSource.topics[topic])
        }
    }
}

