package com.sarang.torang.compose.report

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportActions(onBlock: () -> Unit, onBack: () -> Unit, userName: String)
{
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Support actions") }, navigationIcon = {
            Icon(imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "",
                modifier = Modifier.clickable {
                    onBack.invoke()
                })
        })
    }) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            HorizontalDivider(color = Color.LightGray)
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "What else would you like to do?",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp)
                )
                Text(
                    text = "We won't let them know if you take any of these actions.",
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp, start = 16.dp),
                    color = Color.Gray,
                    fontSize = 13.sp
                )
                HorizontalDivider(color = Color.LightGray)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable {
                            onBlock.invoke()
                        }) {
                    Text(
                        text = "Block $userName",
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp)
                    )
                }
                HorizontalDivider(color = Color.LightGray)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { onBlock.invoke() }) {
                    Text(
                        text = "Restrict $userName",
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp)
                    )
                }
                HorizontalDivider(color = Color.LightGray)
                Text(
                    text = "Learn more about Instagram's Community\nGuidelines",
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSupportActions()
{
    SupportActions(onBack = {}, onBlock = {}, userName = "userName")
}