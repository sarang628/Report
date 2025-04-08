package com.sarang.torang.compose.report

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ReportScreen(onReport: (String) -> Unit) {
    Column {
        Text(
            text = "Report",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color.LightGray)
        Spacer(modifier = Modifier.height(8.dp))
        Column(Modifier.padding(start = 8.dp, end = 8.dp)) {
            Text(
                text = "Why are you reporting this post?",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
            )
            Text(
                text = "Your report is anonymous, except if you're reporting an intellectual property infringement. If someone is in immediate danger, call the local emergency services - don't wait.",
                color = Color.Gray
            )
            ReportText(
                text = "I just don't like it",
                onClick = { onReport.invoke("I just don't like it") })
            ReportText(text = "It's spam", onClick = { onReport.invoke("It's spam") })
            ReportText(
                text = "Nudity or sexual activity",
                onClick = { onReport.invoke("Nudity or sexual activity") })
            ReportText(
                text = "Hate speech or symbols",
                onClick = { onReport.invoke("Hate speech or symbols") })
            ReportText(
                text = "Violence or dangerous organizations",
                onClick = { onReport.invoke("Violence or dangerous organizations") })
            ReportText(
                text = "Bullying or harassment",
                onClick = { onReport.invoke("Bullying or harassment") })
            ReportText(
                text = "False information",
                onClick = { onReport.invoke("False information") })
            ReportText(
                text = "Scam or fraud",
                onClick = { onReport.invoke("Scam or fraud") })
            ReportText(
                text = "Suicide or self-injury",
                onClick = { onReport.invoke("Suicide or self-injury") })
            ReportText(
                text = "Sale of illegal or regulated goods",
                onClick = { onReport.invoke("Sale of illegal or regulated goods") })
        }
    }
}

@Composable
fun ReportText(text: String = "", onClick: () -> Unit) {
    val source = remember { MutableInteractionSource() }
    Text(
        text = text,
        modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp)
            .clickable(
                interactionSource = source,
                indication = null
            ) {
                onClick.invoke()
            },
        fontSize = 14.sp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewReportScreen() {
    ReportScreen(onReport = {})
}