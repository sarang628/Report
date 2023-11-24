package com.sryang.torang.compose.report

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sryang.torang.R

@Composable
fun ThanksForLettingUsKnow(onNext: () -> Unit)
{
    Column(
        Modifier
            .height(400.dp)
            .padding(bottom = 50.dp)
    ) {
        Column(Modifier.padding(start = 40.dp, end = 40.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check), contentDescription = "", alignment = Alignment.Center, modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Thanks for letting us know", fontSize = 18.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "We use these reports to:", color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_info), contentDescription = ""
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Understand problems people are having with different types of content on Instagram.")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_eyes), contentDescription = ""
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "show you less of thiskind of content in the future.")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(Modifier.weight(1f)) {

        }
        HorizontalDivider(color = Color.LightGray)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
        ) {
            Text(text = "Next")
        }
    }
}