package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Rarity
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.util.GearIconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArmorImage(
    modifier: Modifier = Modifier.size(64.dp),
    gearType: GearType,
    gearName: String?,
    rarity: Rarity?
) {
    gearName?.let {
        if (gearType != GearType.DRIFTER) {
            Box(
                modifier = modifier
                    .border(
                        width = 2.dp,
                        brush = when (rarity) {
                            Rarity.LEGENDARY -> WarborneTheme.legendaryBrush
                            Rarity.EPIC -> WarborneTheme.epicBrush
                            Rarity.RARE -> WarborneTheme.rareBrush
                            null -> WarborneTheme.legendaryBrush
                        },
                        shape = RectangleShape
                    )
                    .background(
                        brush = when (rarity) {
                            Rarity.LEGENDARY -> WarborneTheme.legendaryBrushBackground
                            Rarity.EPIC -> WarborneTheme.epicBrushBackground
                            Rarity.RARE -> WarborneTheme.rareBrushBackground
                            null -> WarborneTheme.legendaryBrushBackground
                        },
                        shape = RectangleShape
                    )
            ) {
                Image(
                    modifier = Modifier.size(64.dp),
                    painter = painterResource(
                        GearIconMap.getArmorIcon(
                            gearType,
                            gearName
                        )
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

