package com.example.labapplication

import android.icu.util.Calendar
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labapplication.ui.theme.LabApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        Modifier
                            .padding(innerPadding)
                    )
                    {
                        Header()
                        Body()
                        Lower()
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Header() {
    Column(Modifier
        .fillMaxWidth(1f)){
        Text(
            stringResource(R.string.app_name),
            Modifier
                .fillMaxWidth(1f)
                .padding(5.dp, 0.dp)
                .background(colorResource(R.color.cyan))
        )


        OutlinedTextField(
            "",
            {},
            Modifier
                .height(dimensionResource(R.dimen.search_height))
                .fillMaxWidth(1f)
                .background(colorResource(R.color.gold)),
            maxLines = 1,
            label = {Text(stringResource(R.string.search))})

        Button({},
            Modifier
                .background(colorResource(R.color.teal))
                .width(dimensionResource(R.dimen.menu_weight))
                .height(dimensionResource(R.dimen.menu_height)))
        {
            Text(stringResource(R.string.menu),
                Modifier
                    .fillMaxWidth(1f)
                    .padding(5.dp, 0.dp),
                color = colorResource(R.color.orange))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Body(){
    val developers = stringArrayResource(R.array.developers)

    Column(Modifier
        .fillMaxWidth(1f)
        .background(colorResource(R.color.sea_green)))
    {
        Text(stringResource(R.string.developers))
        for (developer in developers){
            Text(developer, Modifier.padding(8.dp), fontSize = 28.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Lower(){
    val calendar = Calendar.getInstance()
    val hours = calendar.get(Calendar.HOUR_OF_DAY)
    val minutes = calendar.get(Calendar.MINUTE)
    Text("${pluralStringResource(R.plurals.hours, hours, hours)} " +
            pluralStringResource(R.plurals.minutes, minutes, minutes,)
    )
}