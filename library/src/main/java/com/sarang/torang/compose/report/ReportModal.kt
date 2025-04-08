package com.sarang.torang.compose.report

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.uistate.ReportUIState
import com.sarang.torang.viewmodels.ReportViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportModal(
    viewModel: ReportViewModel = hiltViewModel(),
    reviewId: Int,
    onReported: () -> Unit,
    profileServerUrl: String
)
{
    var sheetState = rememberModalBottomSheetState()
    val coroutine = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val navHost = rememberNavController()

    val uiState: ReportUIState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = reviewId, block = {
        viewModel.loadReview(reviewId)
    })

    LaunchedEffect(key1 = uiState.error, block = {
        uiState.error?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearErrorMessage()
        }
    })

    ModalBottomSheet(
        onDismissRequest = { onReported.invoke() }, sheetState = sheetState
    ) {
        Scaffold(snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }) { padding ->
            Box(modifier = Modifier.padding(padding))
            ReportNavHost(navHost = navHost, uiState = uiState, onReport = {
                coroutine.launch {
                    if (viewModel.setReason(it))
                    {
                        navHost.navigate("thanksForLettingUsKnow")
                    }
                }
            }, onBlock = {
                navHost.navigate("areYouHavingProblem")
            }, onBack = {
                navHost.popBackStack()
            }, onNext = {
                navHost.navigate("supportActions")
            }, onRestrictAccount = {
                coroutine.launch {
                    if (viewModel.onRestrictAccount())
                    {
                        sheetState.hide()
                        onReported.invoke()
                    }
                }
            }, isLoading = uiState.isLoading, profileServerUrl = profileServerUrl
            )
        }
    }
}