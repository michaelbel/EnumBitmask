package org.michaelbel.enumbitmask.sample.domain

import org.michaelbel.enumbitmask.R
import org.michaelbel.enumbitmask.sample.data.UserResponse

object UserMapper {

    fun map(userResponse: UserResponse): User {
        return User(
            avatar = userResponse.avatar,
            name = userResponse.name,
            badges = userResponse.badges
        )
    }

    fun mapAvatar(userAvatar: String): Int {
        return when (userAvatar) {
            "avatar1" -> R.drawable.ic_avatar_1
            "avatar2" -> R.drawable.ic_avatar_2
            "avatar3" -> R.drawable.ic_avatar_3
            "avatar4" -> R.drawable.ic_avatar_4
            "avatar5" -> R.drawable.ic_avatar_5
            "avatar6" -> R.drawable.ic_avatar_6
            else -> error("Empty avatar")
        }
    }
}