package com.sryang.torang.compose.report

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ReportNavHost() {
    val navHost = rememberNavController()
    NavHost(navController = navHost, startDestination = "reason") {
        composable("reason") {
            ReportScreen(onReport = {
                navHost.navigate("thanksForLettingUsKnow")
            })
        }
        composable("thanksForLettingUsKnow") {
            ThanksForLettingUsKnow()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewReportNavHost() {
    ModalBottomSheet(onDismissRequest = { /*TODO*/ }) {
        ReportNavHost()
    }
}