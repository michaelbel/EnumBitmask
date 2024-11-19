package org.michaelbel.enumbitmask.sample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.michaelbel.enumbitmask.sample.domain.User
import org.michaelbel.enumbitmask.sample.domain.UserMapper
import org.michaelbel.enumbitmask.sample.ui.theme.AppTheme

@Composable
fun UserBox(
    user: User,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(UserMapper.mapAvatar(user.avatar)),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(56.dp)
                .clip(CircleShape)
        )

        Text(
            text = user.name,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(weight = 1F, fill = false)
        )

        BadgesRow(
            modifier = Modifier.padding(start = 8.dp, end = 16.dp),
            badges = user.badges
        )
    }
}

@Preview
@Composable
private fun UserBoxPreview() {
    AppTheme {
        UserBox(
            user = User(
                avatar = "avatar1",
                name = "Jane Yang",
                badges = 127
            )
        )
    }
}