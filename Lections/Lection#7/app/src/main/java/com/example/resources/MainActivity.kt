package com.example.resources

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.resources.ui.theme.ResourcesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResourcesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Text(stringResource(R.string.welcome),
                            fontSize = 30.sp, modifier = Modifier.width(dimensionResource(R.dimen.header_width)))
                        Text(stringResource(R.string.hello,
                            "Nikita", 19))

                        Button({}) {
                            Text(stringResource(R.string.login_button))
                        }

                        Text(pluralStringResource(R.plurals.cats, 1, 1))
                        Text(pluralStringResource(R.plurals.cats, 3, 3))
                        Text(pluralStringResource(R.plurals.cats, 15, 15))
                    }
                }
            }
        }
    }
}