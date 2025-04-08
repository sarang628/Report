package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sarang.torang.compose.report.ReportModal
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)) {
                    _ReportModal()
                }
            }
        }
    }

    @Composable
    fun _ReportModal()
    {
        var review: Int? by remember { mutableStateOf(null) }
        Column {
            Button(onClick = {
                review = 78
            }) {
                Text(text = "Report")
            }
            review?.let {
                ReportModal(reviewId = it, onReported = {
                    review = null
                }, profileServerUrl = "http://sarang628.iptime.org:89/profile_images/")
            }
        }
    }
}