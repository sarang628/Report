package com.sryang.torang.compose.report

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sryang.torang.uistate.ReportUIState


@Composable
fun ReportNavHost(
    navHost: NavHostController,
    uiState: ReportUIState,
    onReport: (String) -> Unit,
    onNext: () -> Unit,
    onBlock: () -> Unit,
    onBack: () -> Unit,
    onRestrictAccount: () -> Unit,
    isLoading: Boolean,
    profileServerUrl: String
)
{
    if (isLoading)
    {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else
    {
        NavHost(navController = navHost, startDestination = "reason") {
            composable("reason") {
                ReportScreen(onReport = onReport)
            }
            composable("thanksForLettingUsKnow") {
                ThanksForLettingUsKnow(onNext = onNext)
            }
            composable("supportActions") {
                SupportActions(
                    onBlock = onBlock, onBack = onBack, userName = uiState.userName ?: ""
                )
            }
            composable("areYouHavingProblem") {
                AreYouHavingProblem(
                    onRestrictAccount = onRestrictAccount,
                    name = uiState.userName ?: "",
                    profileUrl = if (uiState.profileUrl != null) profileServerUrl + uiState.profileUrl else ""
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewReportNavHost()
{
    ModalBottomSheet(onDismissRequest = { /*TODO*/ }) {/*ReportNavHost(onRestrictAccount = {},
            onNext = {},
            onBack = {},
            onBlock = {},
            onReport = {},
            navHost = rememberNavController(),
            isLoading = false,
        )*/
    }
}