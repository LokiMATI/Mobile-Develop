package com.example.clicker.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clicker.GameViewModel
import com.example.clicker.Particle
import com.example.clicker.ParticleAnimation
import com.example.clicker.R
import kotlinx.coroutines.coroutineScope

@Composable
fun GameScreen(vm : GameViewModel){
    Box(Modifier.fillMaxSize()){
        val particles = remember { mutableStateListOf<Particle>() }
        var buttonPosition by remember { mutableStateOf(Offset.Zero) }
        var isPressed by remember { mutableStateOf(false) }
        val scale by animateFloatAsState(
            if (isPressed) 0.95f else 1f,
            animationSpec = tween(100)
        )
        Box(Modifier
            .size(300.dp)
            .clip(CircleShape)
            .align(Alignment.Center)
//            .clickable{
//                vm.onTap()
//                repeat(5){
//                    particles.add(Particle(50f, 50f))
//                }
//            }
            .onGloballyPositioned {
                buttonPosition = it.positionInParent()
            }
            .pointerInput(Unit) {
                coroutineScope {
                    while (true) {
                        awaitPointerEventScope {
                            val down = awaitFirstDown()
                            val pos = down.position + buttonPosition
                            isPressed = true
                            vm.onTap()
                            repeat(5) {
                                particles.add(Particle(pos.x, pos.y))
                            }
                            down.consume()

                            val up = waitForUpOrCancellation()
                            if (up != null) {
                                isPressed = false
                            }
                        }
                    }
                }
            }
        ){
            Image(painterResource(R.drawable.cthulhu_star),
                "Background",
                modifier = Modifier.fillMaxSize())

            Image(painterResource(R.drawable.cthulhu),
                "Cthulhu",
                modifier = Modifier
                    .graphicsLayer(scaleX = scale, scaleY = scale)
                    .fillMaxSize(0.7f)
                    .align(Alignment.Center))
        }
        ParticleAnimation(particles)
    }
}