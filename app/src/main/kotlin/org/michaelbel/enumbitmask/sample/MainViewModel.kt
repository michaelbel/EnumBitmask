@file:OptIn(ExperimentalSerializationApi::class)

package org.michaelbel.enumbitmask.sample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.michaelbel.enumbitmask.sample.data.UserResponse
import org.michaelbel.enumbitmask.sample.domain.User
import org.michaelbel.enumbitmask.sample.domain.UserMapper

class MainViewModel(
    private val application: Application
): AndroidViewModel(application) {

    val usersListFlow: StateFlow<List<User>> = flow {
        val users = withContext(Dispatchers.IO) {
            application.applicationContext.assets.open(ASSETS_FILE_NAME).use { inputStream ->
                val format = Json { ignoreUnknownKeys = true }
                val usersJsonData: List<UserResponse> = format.decodeFromStream(inputStream)
                usersJsonData.map(UserMapper::map)
            }
        }
        emit(users)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = emptyList()
    )

    private companion object {
        private const val ASSETS_FILE_NAME = "users.json"
    }
}