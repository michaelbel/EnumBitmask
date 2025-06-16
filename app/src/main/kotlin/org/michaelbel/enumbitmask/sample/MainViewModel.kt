@file:OptIn(ExperimentalSerializationApi::class)

package org.michaelbel.enumbitmask.sample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.michaelbel.enumbitmask.sample.data.UserResponse
import org.michaelbel.enumbitmask.sample.domain.User
import org.michaelbel.enumbitmask.sample.domain.UserMapper
import org.michaelbel.enumbitmask.sample.domain.isVerified

class MainViewModel(
    private val application: Application
): AndroidViewModel(application) {

    private val usersListFlow: Flow<List<User>> = flow {
        val users = withContext(Dispatchers.Default) {
            application.applicationContext.assets.open(ASSETS_FILE_NAME).use { inputStream ->
                val format = Json { ignoreUnknownKeys = true }
                val usersJsonData: List<UserResponse> = format.decodeFromStream(inputStream)
                usersJsonData.map(UserMapper::map)
            }
        }
        emit(users)
    }

    fun filteredUsersStateFlow(enabled: Boolean): StateFlow<List<User>> {
        return usersListFlow.map { users ->
            if (enabled) users.filter { it.badges.isVerified } else users
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )
    }

    private companion object {
        private const val ASSETS_FILE_NAME = "users.json"
    }
}