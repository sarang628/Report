package com.sryang.torang.compose.report

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sryang.torang.viewmodels.ReportViewModel

@Composable
fun ReportNavHost(reportViewModel: ReportViewModel = hiltViewModel())
{
    val navHost = rememberNavController()
    NavHost(navController = navHost, startDestination = "reason") {
        composable("reason") {
            ReportScreen(onReport = {
                navHost.navigate("thanksForLettingUsKnow")
            })
        }
        composable("thanksForLettingUsKnow") {
            ThanksForLettingUsKnow(onNext = {
                navHost.navigate("supportActions")
            })
        }
        composable("supportActions") {
            SupportActions(onBlock = {
                navHost.navigate("areYouHavingProblem")
            }, onBack = {
                navHost.popBackStack()
            })
        }
        composable("areYouHavingProblem") {
            AreYouHavingProblem(onRestrictAccount = {

            })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewReportNavHost()
{
    ModalBottomSheet(onDismissRequest = { /*TODO*/ }) {
        ReportNavHost()
    }
}