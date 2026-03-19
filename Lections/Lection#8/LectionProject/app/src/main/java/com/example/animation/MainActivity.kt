package com.example.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.animation.ui.theme.AnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        ColorAnimationExample()
                        OffsetAnimationExample()
                        RotationAnimationExample()
                    }
                }
            }
        }
    }
}

@Composable
fun ColorAnimationExample(){
    var isBlue by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (isBlue) Color.Blue else Color.Red,
        animationSpec = tween(1000)
    )

    Box(
        Modifier
            .size(200.dp)
            .background(color)
            .clickable{isBlue=!isBlue}
    )
}

@Composable
fun OffsetAnimationExample(){
    var moved by remember { mutableStateOf(false) }

    val offsetX by animateDpAsState(
        targetValue = if (moved) 200.dp else 100.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy)
    )

    Box(
        Modifier
            .size(offsetX)
            .offset(x = offsetX)
            .background(Color.Green)
            .clickable{moved=!moved}
    )
}

@Composable
fun RotationAnimationExample(){
    var rotated by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (rotated) 360f else 0f,
        animationSpec = tween(1000)
    )

    Box(
        Modifier
            .size(200.dp)
            .graphicsLayer(rotationZ = rotation)
            .background(Color.Magenta)
            .clickable{rotated=!rotated}
    )
}