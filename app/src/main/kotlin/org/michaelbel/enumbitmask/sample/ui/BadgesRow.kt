package org.michaelbel.enumbitmask.sample.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.michaelbel.enumbitmask.R
import org.michaelbel.enumbitmask.sample.domain.isCrown
import org.michaelbel.enumbitmask.sample.domain.isHeart
import org.michaelbel.enumbitmask.sample.domain.isNew
import org.michaelbel.enumbitmask.sample.domain.isOld
import org.michaelbel.enumbitmask.sample.domain.isRich
import org.michaelbel.enumbitmask.sample.domain.isStar
import org.michaelbel.enumbitmask.sample.domain.isVerified
import org.michaelbel.enumbitmask.sample.ui.theme.AppTheme
import org.michaelbel.enumbitmask.sample.ui.theme.amber
import org.michaelbel.enumbitmask.sample.ui.theme.blue
import org.michaelbel.enumbitmask.sample.ui.theme.brown
import org.michaelbel.enumbitmask.sample.ui.theme.green
import org.michaelbel.enumbitmask.sample.ui.theme.purple
import org.michaelbel.enumbitmask.sample.ui.theme.red
import org.michaelbel.enumbitmask.sample.ui.theme.yellow

@Composable
fun BadgesRow(
    modifier: Modifier = Modifier,
    badges: Int
) {
    Row(
        modifier = modifier
            .wrapContentWidth()
            .height(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (badges.isVerified) {
            Icon(
                painter = painterResource(R.drawable.ic_badge_verified),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.blue
            )
        }

        if (badges.isOld) {
            Icon(
                painter = painterResource(R.drawable.ic_badge_old),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.brown
            )
        }

        if (badges.isNew) {
            Icon(
                painter = painterResource(R.drawable.ic_badge_new),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.green
            )
        }

        if (badges.isStar) {
            Icon(
                painter = painterResource(R.drawable.ic_badge_star),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.yellow
            )
        }

        if (badges.isCrown) {
            Icon(
                painter = painterResource(R.drawable.ic_badge_crown),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.purple
            )
        }

        if (badges.isHeart) {
            Icon(
                painter = painterResource(R.drawable.ic_badge_heart),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.red
            )
        }

        if (badges.isRich) {
            Icon(
                painter = painterResource(R.drawable.ic_badge_rich),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.amber
            )
        }
    }
}

@Preview
@Composable
private fun BadgesRowPreview() {
    AppTheme {
        BadgesRow(
            modifier = Modifier,
            badges = 127
        )
    }
}