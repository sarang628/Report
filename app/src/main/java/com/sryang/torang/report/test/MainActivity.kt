package com.sryang.torang.report.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.sryang.torang.compose.report.ReportModal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
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
}