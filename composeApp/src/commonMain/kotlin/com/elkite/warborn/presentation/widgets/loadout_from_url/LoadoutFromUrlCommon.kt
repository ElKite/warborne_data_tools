package com.elkite.warborn.presentation.widgets.loadout_from_url

import androidx.compose.runtime.Composable
import com.elkite.warborn.domain.entities.gear.Loadout

@Composable
expect fun LoadoutFromUrl(
    loadout: Loadout,
    onLoadoutUrlUpdate: (String) -> Unit,
)
