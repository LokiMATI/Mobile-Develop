package com.example.clicks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clicks.ui.theme.ClicksTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClicksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    TransformExample()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ){
        var text by remember { mutableStateOf("") }
        Box(Modifier
            .size(200.dp)
            .background(Color.Yellow)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { text = "Press" },
                    onTap = { text = "Tap" },
                    onDoubleTap = { text = "Double Tap" },
                    onLongPress = { text = "Long Press" }
                )
            },
            contentAlignment = Alignment.Center
        ){
            Text(text, fontSize = 20.sp)
        }

        var offsetX by remember { mutableFloatStateOf(0f) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), 0) }
                .size(200.dp)
                .background(Color.Green)
                .draggable(
                    state = rememberDraggableState {
                        offsetX += it
                    },
                    orientation = Orientation.Horizontal
                )
        )

        var offset by remember { mutableStateOf(Offset.Zero) }

        Box(
            Modifier
                .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
                .size(200.dp)
                .background(Color.Green)
                .draggable2D(
                    state = rememberDraggable2DState {
                        offset += it
                    }
                )
        )

        var xOffset by remember { mutableStateOf(0f) }
        var yOffset by remember { mutableStateOf(0f) }

        Box(Modifier
            .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
            .size(200.dp)
            .background(Color.Yellow)
            .pointerInput(Unit) {
                detectDragGestures { _, delta ->
                    xOffset += delta.x
                    yOffset += delta.y
                }
            }
        )
    }
}

@Composable
fun TransformExample(){
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        var scale by remember { mutableStateOf(1f) }
        var angle by remember { mutableStateOf(0f) }
        var offset by remember { mutableStateOf(Offset.Zero) }
        val state = rememberTransformableState {
                scaleChange, offsetChange, rotationChange ->
            scale *= scaleChange
            angle += rotationChange
            offset += offsetChange
        }
        Box(
            Modifier
                .graphicsLayer(scaleX = scale,
                    scaleY = scale,
                    rotationZ = angle,
                    translationX = offset.x,
                    translationY = offset.y,)
                .transformable(state)
                .size(200.dp)
                .background(Color.Blue)

        )
    }
}