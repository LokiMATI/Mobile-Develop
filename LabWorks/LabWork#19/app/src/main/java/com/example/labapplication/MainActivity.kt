package com.example.labapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labapplication.ui.theme.LabApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var selectedProduct by remember { mutableStateOf<Product?>(null) }
                    val products = mutableStateListOf(
                        Product("1", "Товар №1", 20f, R.drawable.oil),
                        Product("1", "Товар №2", 20f, R.drawable.tea),
                        Product("1", "Товар №3", 20f, R.drawable.eggs),
                        Product("1", "Товар №4", 20f, R.drawable.meat),
                        Product("1", "Товар №5", 20f, R.drawable.milk),
                        Product("1", "Товар №6", 20f, R.drawable.apple),
                        Product("1", "Товар №7", 20f, R.drawable.banana),
                        Product("1", "Товар №8", 20f, R.drawable.bread),
                        Product("1", "Товар №9", 20f, R.drawable.cabbage),
                        Product("1", "Товар №10", 20f, R.drawable.coffe),
                        Product("1", "Товар №12", 20f, R.drawable.cookies),
                        Product("1", "Товар №13", 20f, R.drawable.cucumber),
                        Product("1", "Товар №14", 20f, R.drawable.flour),
                        Product("1", "Товар №15", 20f, R.drawable.gingerbread),
                        Product("1", "Товар №16", 20f, R.drawable.juice),
                        Product("1", "Товар №17", 20f, R.drawable.porridge),
                        Product("1", "Товар №18", 20f, R.drawable.sausage),
                        Product("1", "Товар №19", 20f, R.drawable.shrimp),
                        Product("1", "Товар №20", 20f, R.drawable.tomato)
                        )
                    LazyColumn(Modifier
                        .padding(innerPadding)
                        .fillMaxSize())
                    {
                        stickyHeader { selectedProduct.let { Text(it?.title?:"") } }
                        items(products){
                            product ->
                                HorizontalProductCard(product, Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth()
                                    .border(4.dp, Color.Black)
                                    .height(200.dp), {selectedProduct = product})
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HorizontalProductCard(product : Product, modifier: Modifier, onClick : () -> Unit){
    Card(modifier= modifier, onClick = onClick){
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {
            Image(ImageBitmap.imageResource(product.imageId),
                "Изображение с идентификатором #${product.imageId}",
                Modifier.weight(20f))

            Column(Modifier.weight(80f).background(Color.Transparent)) {
                Text(product.title)
                Text(product.price.toString())
            }
        }

    }
}

@Composable
fun VerticalProductCard(product : Product, modifier: Modifier, onClick : () -> Unit){
    Card(onClick, modifier){
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(ImageBitmap.imageResource(product.imageId),
                "Изображение с идентификатором #${product.imageId}",
                modifier = Modifier
                    .clip(CircleShape)
                    .weight(70f))

            Column(Modifier.weight(30f).background(Color.Transparent)) {
                Text(product.title)
                Text(product.price.toString())
            }
        }

    }
}
