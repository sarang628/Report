package com.sryang.torang.compose.report

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SupportActions() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Support actions") }, navigationIcon = {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "")
            })
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {

        }
    }
}