@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.enumbitmask.sample.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.michaelbel.enumbitmask.R
import org.michaelbel.enumbitmask.sample.MainViewModel
import org.michaelbel.enumbitmask.sample.domain.User

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    var verifiedFilterEnabled by rememberSaveable { mutableStateOf(false) }
    val usersList by viewModel.filteredUsersStateFlow(verifiedFilterEnabled).collectAsStateWithLifecycle()
    val isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT

    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.displayCutout),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name)
                    )
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { verifiedFilterEnabled = !verifiedFilterEnabled }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = verifiedFilterEnabled,
                        onCheckedChange = null
                    )

                    Text(
                        text = stringResource(R.string.filter_verified),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        },
        floatingActionButtonPosition = if (isPortrait) FabPosition.Center else FabPosition.End
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(
                items = usersList,
                key = User::name
            ) { user ->
                UserBox(
                    user = user,
                    modifier = Modifier.animateItem()
                )
            }
        }
    }
}