package com.example.localrestapi.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.localrestapi.view.route.DestinasiDetail
import com.example.localrestapi.view.route.DestinasiEdit
import com.example.localrestapi.view.route.DestinasiEntry
import com.example.localrestapi.view.route.DestinasiHome
import com.example.localrestapi.view.DetailSiswaScreen
import com.example.localrestapi.view.EditSiswaScreen
import com.example.localrestapi.view.EntrySiswaScreen
import com.example.localrestapi.view.HomeScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {

        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                navigateToItemUpdate = { id ->
                    navController.navigate("${DestinasiDetail.route}/$id")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetail.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEdit.route}/$id")
                },
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            DestinasiEdit.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEdit.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            EditSiswaScreen(
                navigateBack = {
                    navController.popBackStack()
                },
                onNavigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}
