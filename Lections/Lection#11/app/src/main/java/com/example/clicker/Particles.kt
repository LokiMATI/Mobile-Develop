package com.example.clicker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import com.example.clicker.ui.theme.cthulhuTextStyle
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

data class Particle(
    var x: Float,
    var y: Float,
    val speed: Float = Random.nextFloat() * 5 + 2,
    val angle: Float = Random.nextFloat() * 2 * PI.toFloat(),
    val letter: String = ('A'..'Z').random().toString(),
    var alpha: Float = 1f,
    var lifetime: Float = 1f
){
    val speedX = cos(angle) * speed
    val speedY = sin(angle) * speed

    fun update(){
        x += speedX
        y += speedY

        alpha -= 0.02f
        lifetime -= 0.02f
    }
}

@Composable
fun ParticleAnimation(particles : MutableList<Particle>){

    LaunchedEffect(Unit) {
        while (true){
            delay(16L)
            particles.removeAll {
                it.update()
                it.lifetime <= 0
            }
        }
    }

    val textMeasurer = rememberTextMeasurer()
    Canvas(Modifier.fillMaxSize()){
        for (particle in particles){
            val text = textMeasurer.measure(
                particle.letter,
                cthulhuTextStyle
                )
            drawText(text,
                color = Color(0.38f, 0.96f, 0.86f, particle.alpha),
                topLeft = Offset(particle.x, particle.y),
                shadow = Shadow(Color.Black, Offset(5f, 5f), 10f)
            )
        }
    }
}