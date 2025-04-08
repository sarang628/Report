package com.sarang.torang.compose.report

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sarang.torang.R

@Composable
fun AreYouHavingProblem(onRestrictAccount: () -> Unit, name: String, profileUrl: String)
{
    Column(
        Modifier
            .height(600.dp)
            .padding(start = 16.dp, end = 16.dp, bottom = 50.dp)
    ) {
        Column(
            Modifier.padding(start = 8.dp, end = 8.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    model = profileUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Are you having a problem\nwith $name?",
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.ic_check), contentDescription = "")
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Limit unwanted interactions without having to block or unfollow someone you know.")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.ic_check), contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "You'll control if others can see their new comments on your posts.")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.ic_check), contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "They won't see when you've read messages and their chat will be removed from your Chats list. You can still search for")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { onRestrictAccount.invoke() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Restrict account")
        }
    }
}

@Preview
@Composable
fun PreviewAreYouHavingProblem()
{
    AreYouHavingProblem(name = "name", profileUrl = "profileUrl", onRestrictAccount = {})
}