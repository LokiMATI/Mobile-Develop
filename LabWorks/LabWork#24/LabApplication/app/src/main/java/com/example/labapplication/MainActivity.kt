package com.example.labapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.labapplication.ui.theme.LabApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)){
//                        ColorAnimationExample()
//                        ColorAnimationWithKeyFramesExample()
//                        SizeAnimationExample()
//                        ChangePictureSizeAnimation()
//                        InfinityColorAnimation()


                    }
                }
            }
        }
    }
}

//@Composable
//fun Task2(){
//    var animatable by remember { Animatable(Color.Red, ) }
//}

@Composable
fun Task3(){
    val height = 100
    val width = 200

    var state by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = state)

    var animatedSize: Dp by transition.animateDp(transitionSpec = {tween(1000)}) {
        state -> if (state) {(height * 3).dp; (width * 3).dp} else { height.dp; width.dp}
    }
}

@Composable
fun ColorAnimationExample(){
    var isBlue by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (isBlue) Color.Blue else Color.Red,
        animationSpec = tween(3000)
    )

    Box(
        Modifier
            .size(200.dp)
            .background(color)
            .clickable { isBlue = !isBlue }
    )
}

@Composable
fun ColorAnimationWithKeyFramesExample(){
    var isBlue by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (isBlue) Color.Blue else Color.Red,
        animationSpec = keyframes {
            durationMillis = 10000
            Color.Yellow.at(3000)
            Color.Green.at(6000)
            Color.Black.at(9000)
        }
    )

    Box(
        Modifier
            .size(200.dp)
            .background(color)
            .clickable { isBlue = !isBlue }
    )
}

@Composable
fun SizeAnimationExample(){

    var boxSize by remember { mutableStateOf(false) }
    val boxState by animateDpAsState(
        targetValue = if(boxSize) 200.dp else 100.dp,
        animationSpec = repeatable(3, animation = tween(1000))
    )

    Box(
        Modifier
            .size(boxState)
            .background(Color.Green)
            .clickable { boxSize = !boxSize}
    )
}

@Composable
fun ChangePictureSizeAnimation(){
    var boxSize by remember { mutableStateOf(false) }
    val boxState by animateDpAsState(
        targetValue = if(boxSize) 200.dp else 100.dp,
        animationSpec =  spring(1f)
    )

    Image(imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_foreground), "", modifier = Modifier.size(boxState)
        .clickable { boxSize = !boxSize})
}

@Composable
fun InfinityColorAnimation(){
    var isBlue by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (isBlue) Color.Blue else Color.Red,
        animationSpec = infiniteRepeatable(animation = tween(1000), repeatMode = RepeatMode.Reverse)
    )

    Box(
        Modifier
            .size(200.dp)
            .background(color)
            .clickable { isBlue = !isBlue }
    )
}