package com.rabarka.lazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabarka.lazyrow.ui.theme.LazyRowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyRowShower2(flowerList = flowerList(), modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun LazyRowShower() {
    val phoneNameList = listOf(
        "Google ",
        "Samsung ",
        "Apple ",
        "OnePlus ",
        "Motorola ",
        "Xiaomi ",
        "Vivo ",
        "Spice "
    )
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        phoneNameList.forEach { phone ->
            Text(text = phone)
        }
    }
}

@Composable
fun LazyRowShower1() {
    LazyRow {
        item {
            Text(text = "First Item  ")
        }
        items(5) {
            Text(text = "Text No: $it ")
        }
        item {
            Text(text = "Last Item")
        }
    }
}


@Composable
fun LazyRowShower2(flowerList: List<Flower>, modifier: Modifier) {
    LazyRow(modifier = modifier) {
        items(flowerList) { flower ->
            FlowerCard(flower = flower, modifier = Modifier.padding(8.dp))
        }
    }
}


@Composable
fun FlowerCard(flower: Flower, modifier: Modifier) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp).size(150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = flower.imageResId),
                contentDescription = stringResource(id = flower.nameResId),
                modifier = Modifier.size(100.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = flower.nameResId),
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

fun flowerList(): List<Flower> {
    return listOf(
        Flower(R.drawable.rose1, R.string.rose_1),
        Flower(R.drawable.rose2, R.string.rose_2),
        Flower(R.drawable.rose3, R.string.rose_3),
        Flower(R.drawable.rose4, R.string.rose_4),
        Flower(R.drawable.rose5, R.string.rose_5),
        Flower(R.drawable.rose6, R.string.rose_6),
        Flower(R.drawable.rose7, R.string.rose_7)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    LazyRowTheme {
        LazyRowShower2(flowerList = flowerList(), modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LazyRowTheme {
        FlowerCard(
            flower = Flower(R.drawable.rose1, R.string.rose_1),
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    LazyRowTheme {
        LazyRowShower1()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyRowTheme {
        LazyRowShower()
    }
}