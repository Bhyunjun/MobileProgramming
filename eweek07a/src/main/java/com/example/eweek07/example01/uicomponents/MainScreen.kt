package com.example.eweek07.example01.uicomponents

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.eweek07.example01.navGraph.NavGraph

@SuppressLint("RestrictedApi")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavGraph(navController = navController)

    navController.addOnDestinationChangedListener { _, _, _ ->
        navController.currentBackStack.value.forEachIndexed { index, entry ->
            Log.d("backStack", "$index ${entry.destination.route}")
        }
    }
}