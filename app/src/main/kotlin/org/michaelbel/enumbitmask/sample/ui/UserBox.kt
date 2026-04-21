package org.michaelbel.enumbitmask.sample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
            .height(64.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(UserMapper.mapAvatar(user.avatar)),
            contentDescription = null,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
        )

        Text(
            text = user.name,
            modifier = Modifier.weight(weight = 1F, fill = false),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        BadgesRow(
            badges = user.badges
        )
    }
}

@Preview(showBackground = true)
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
