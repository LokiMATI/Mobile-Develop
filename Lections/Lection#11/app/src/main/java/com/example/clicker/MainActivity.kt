package com.example.clicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clicker.screens.GameScreen
import com.example.clicker.screens.ShopScreen
import com.example.clicker.ui.theme.ClickerTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickerGame()
        }
    }
}

data class PageData(val name: String, val icon: ImageVector)

@Composable
fun ClickerGame(vm : GameViewModel = viewModel()){
    val pagerState = rememberPagerState() { 2 }
    val pages = remember { mutableStateMapOf(
        0 to PageData("Main", Icons.Default.Home),
        1 to PageData("Shop", Icons.Default.ShoppingCart)
    ) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true){
            delay(1000)
            vm.onAutoClick()
        }
    }

    var showDialog by remember { mutableStateOf(false) }
    var offlineIncome by remember { mutableStateOf(BigDecimal(0)) }

    LaunchedEffect(Unit) {
        offlineIncome = vm.calculateOfflineIncome().await()
        showDialog = offlineIncome > BigDecimal(0)
        vm.score += offlineIncome
    }

    if (showDialog){
        AlertDialog(
            onDismissRequest = {showDialog = false},
            title = {Text("С возвращением!")},
            text = {Text("Последователи собрали ${offlineIncome.formatNumber()} душ, пока вы остутствовали")},
            confirmButton = {
                Button({showDialog = false}) {
                    Text("Ктулху фхтагн")
                }
            }
        )
    }

    ClickerTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column(Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly) {
                    Text("Душ принесено в жертву",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer)
                    Text("%.2f".format(vm.score.formatNumber()),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            },
            bottomBar = {
                Row(Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    pages.forEach { (n, page) ->
                        Button({
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(n, animationSpec = tween(300))
                            }
                        }, Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor =
                                if (pagerState.currentPage == n)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.primaryContainer
                            )
                        ) {
                            Icon(page.icon, page.name)
                        }
                    }
                }
            }
        ) { innerPadding ->
            HorizontalPager(pagerState,
                Modifier.padding(innerPadding)){
                page ->
                when(page) {
                    0 -> GameScreen(vm)
                    1 -> ShopScreen(vm)
                }
            }
        }
    }

    ApplicationLifeTimeObserver { vm.saveData() }
}

@Composable
fun ApplicationLifeTimeObserver(onExit: ()->Unit){
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = object : DefaultLifecycleObserver{
            override fun onStop(owner: LifecycleOwner) {
                onExit()
                super.onStop(owner)
            }

            override fun onDestroy(owner: LifecycleOwner) {
                onExit()
                super.onDestroy(owner)
            }

            override fun onPause(owner: LifecycleOwner) {
                onExit()
                super.onPause(owner)
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}