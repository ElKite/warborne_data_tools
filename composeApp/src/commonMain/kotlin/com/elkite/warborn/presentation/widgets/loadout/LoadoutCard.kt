package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource


@Composable
fun LoadoutCard(
    modifier: Modifier = Modifier,
    loadout: Loadout,
    selectedLoadout: LoadoutType,
    onClick: (LoadoutType) -> Unit,
) {
    Column(
        modifier = modifier.wrapContentSize()
            .padding(16.dp)
    ) {
            Box(
                modifier = Modifier
                    .height(470.dp)
                    .width(344.dp)
                    .background(Color.Black)
                    .clip(RectangleShape) // Clip to the border shape
                    .border(
                        width = 3.dp,
                        brush = WarborneTheme.legendaryBrush,
                        shape = RectangleShape
                    )
                    .paint(
                        painter = painterResource(IconMap.getDrifterCard(drifter = loadout.drifter)),
                        contentScale = ContentScale.Crop,
                    )
                    .clickable { onClick(LoadoutType.DRIFTER) }
                    .padding(16.dp),
            ) {
                Column(modifier = Modifier.align(Alignment.TopEnd)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        LoadoutArmorIcon(
                            isSelected = selectedLoadout == LoadoutType.WEAPON,
                            loadoutType = LoadoutType.WEAPON,
                            gearName = loadout.weapon?.gearName,
                            gearType = loadout.weapon?.associatedGearType,
                            rarity = loadout.weapon?.rarity,
                            onClick = {
                                onClick(LoadoutType.WEAPON)
                            }
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        LoadoutModIcon(
                            selectedLoadout == LoadoutType.MOD_WEAPON,
                            modifier = Modifier.size(48.dp),
                            mod = loadout.modWeapon,
                            onClick = {
                                onClick(LoadoutType.MOD_WEAPON)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        LoadoutArmorIcon(
                            isSelected = selectedLoadout == LoadoutType.HEAD,
                            loadoutType = LoadoutType.HEAD,
                            gearName = loadout.head?.gearName,
                            gearType = loadout.head?.associatedGearType,
                            rarity = loadout.head?.rarity,
                            onClick = {
                                onClick(LoadoutType.HEAD)
                            }
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        LoadoutModIcon(
                            selectedLoadout == LoadoutType.MOD_HEAD,
                            mod = loadout.modHead,
                            onClick = {
                                onClick(LoadoutType.MOD_HEAD)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        LoadoutArmorIcon(
                            isSelected = selectedLoadout == LoadoutType.CHEST,
                            loadoutType = LoadoutType.CHEST,
                            gearName = loadout.chest?.gearName,
                            gearType = loadout.chest?.associatedGearType,
                            rarity = loadout.chest?.rarity,
                            onClick = {
                                onClick(LoadoutType.CHEST)
                            }
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        LoadoutModIcon(
                            selectedLoadout == LoadoutType.MOD_CHEST,
                            mod = loadout.modChest,
                            onClick = {
                                onClick(LoadoutType.MOD_CHEST)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        LoadoutArmorIcon(
                            isSelected = selectedLoadout == LoadoutType.BOOTS,
                            loadoutType = LoadoutType.BOOTS,
                            gearName = loadout.boots?.gearName,
                            gearType = loadout.boots?.associatedGearType,
                            rarity = loadout.boots?.rarity,
                            onClick = {
                                onClick(LoadoutType.BOOTS)
                            }
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        LoadoutModIcon(
                            selectedLoadout == LoadoutType.MOD_BOOTS,
                            mod = loadout.modBoots,
                            onClick = {
                                onClick(LoadoutType.MOD_BOOTS)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                }
                GearStylizedTextTitle(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    text = loadout.drifter?.name ?: "Select drifter"
                )

            }
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier = Modifier.wrapContentSize()) {
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.BASIC_ATTACK,
                loadoutType = LoadoutType.BASIC_ATTACK,
                spell = loadout.basicAttack,
                onClick = { onClick(LoadoutType.BASIC_ATTACK) },
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.COMMON_SKILL,
                loadoutType = LoadoutType.COMMON_SKILL,
                spell = loadout.commonSkill,
                onClick = { onClick(LoadoutType.COMMON_SKILL) },
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.WEAPON,
                loadoutType = LoadoutType.WEAPON,
                spell = loadout.weapon,
                onClick = { onClick(LoadoutType.WEAPON) },
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.DRIFTER,
                loadoutType = LoadoutType.DRIFTER,
                spell = loadout.drifter?.spell,
                onClick = { onClick(LoadoutType.DRIFTER) },
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.CHEST,
                loadoutType = LoadoutType.CHEST,
                spell = loadout.chest,
                onClick = { onClick(LoadoutType.CHEST) },
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.BOOTS,
                loadoutType = LoadoutType.BOOTS,
                spell = loadout.boots,
                onClick = { onClick(LoadoutType.BOOTS) },
                modifier = Modifier.size(48.dp)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row(modifier = Modifier.wrapContentSize()) {
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.HEAD,
                loadoutType = LoadoutType.PASSIVE,
                spell = loadout.head,
                onClick = { onClick(LoadoutType.HEAD) },
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.PASSIVE,
                loadoutType = LoadoutType.PASSIVE,
                spell = loadout.passive,
                onClick = { onClick(LoadoutType.PASSIVE) },
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutSpellIcon(
                isSelected = selectedLoadout == LoadoutType.DRIFTER,
                loadoutType = LoadoutType.PASSIVE,
                spell = loadout.drifter?.passive,
                onClick = { onClick(LoadoutType.DRIFTER) },
                modifier = Modifier.size(48.dp)
            )
        }
    }
}