package org.michaelbel.enumbitmask.sample.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("avatar") val avatar: String,
    @SerialName("name") val name: String,
    @SerialName("badges") val badges: Int
)