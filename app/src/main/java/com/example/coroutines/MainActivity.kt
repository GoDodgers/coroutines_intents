package com.example.coroutines

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coroutines.ui.theme.CoroutinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutinesTheme {
                Surface {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen {
                                navHostController.navigate("second")
                            }
                        }
                        composable("second") {
                            SecondScreen {
                                Intent(
                                    this@MainActivity, NewActivity::class.java
                                ).also {
                                    startActivity(it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onNavClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onNavClick) {
            Text("go")
        }
    }
}

@Composable
fun SecondScreen(onNavClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onNavClick) {
            Text("go")
        }
    }
}