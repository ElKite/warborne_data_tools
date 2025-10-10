package com.elkite.warborn.presentation.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.Translation
import com.elkite.warborn.domain.entities.common.GearCategory
import com.elkite.warborn.domain.entities.common.ModCategory
import com.elkite.warborn.domain.entities.consumable.Consumable
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.ArmorSlot
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.loadout.Loadout
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.domain.entities.mod.ArmorMod
import com.elkite.warborn.domain.entities.mod.WeaponMod
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.card.ArmorCard
import com.elkite.warborn.presentation.widgets.card.ConsumableCard
import com.elkite.warborn.presentation.widgets.card.DrifterCard
import com.elkite.warborn.presentation.widgets.card.ModCard
import com.elkite.warborn.presentation.widgets.card.WeaponCard
import com.elkite.warborn.presentation.widgets.card.common.CardContainer
import com.elkite.warborn.presentation.widgets.consumable.ConsumableSmallList
import com.elkite.warborn.presentation.widgets.drifter.DrifterSmallList
import com.elkite.warborn.presentation.widgets.gear.ArmorSmallList
import com.elkite.warborn.presentation.widgets.gear.WeaponSmallList
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCard
import com.elkite.warborn.presentation.widgets.loadout_from_url.LoadoutFromUrl
import com.elkite.warborn.presentation.widgets.mod.ModSmallList
import com.elkite.warborn.presentation.widgets.utils.ClickableText
import com.elkite.warborn.presentation.widgets.utils.CopyButton
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Common_ParagonWarehouse
import com.elkite.warborn.resources.ItemIcon_MODCore
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.equip_medicine_4_3
import org.jetbrains.compose.resources.painterResource

@Composable
fun TranslationColumn(
    modifier: Modifier,
    translation: Translation,
    onLanguageSelected: (Translation) -> Unit
) {
    Column {
        GearStylizedText(text = "Translations other than EN are community ")
        GearStylizedText(text = "driven and may be incomplete or outdated.")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = translation == Translation.EN,
                onClick = { onLanguageSelected(Translation.EN) },
                modifier = modifier.padding(bottom = 8.dp),
                colors = RadioButtonDefaults.colors(
                    selectedColor = WarborneColorTheme.borderSkillHightlightColor,
                    unselectedColor = WarborneColorTheme.borderSkillColor,
                    disabledSelectedColor = WarborneColorTheme.textBackgroundColor,
                    disabledUnselectedColor = WarborneColorTheme.textBackgroundColor,
                )
            )
            GearStylizedText(text = "EN")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = translation == Translation.RU,
                onClick = { onLanguageSelected(Translation.RU) },
                modifier = modifier.padding(bottom = 8.dp),
                colors = RadioButtonDefaults.colors(
                    selectedColor = WarborneColorTheme.borderSkillHightlightColor,
                    unselectedColor = WarborneColorTheme.borderSkillColor,
                    disabledSelectedColor = WarborneColorTheme.textBackgroundColor,
                    disabledUnselectedColor = WarborneColorTheme.textBackgroundColor,
                )
            )
            GearStylizedText(text = "RU")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = translation == Translation.KR,
                onClick = { onLanguageSelected(Translation.KR) },
                modifier = modifier.padding(bottom = 8.dp),
                colors = RadioButtonDefaults.colors(
                    selectedColor = WarborneColorTheme.borderSkillHightlightColor,
                    unselectedColor = WarborneColorTheme.borderSkillColor,
                    disabledSelectedColor = WarborneColorTheme.textBackgroundColor,
                    disabledUnselectedColor = WarborneColorTheme.textBackgroundColor,
                )
            )
            GearStylizedText(text = "KR")
        }
    }
}

@Composable
fun LoadoutColumn(
    loadout: Loadout,
    onLoadoutUrlUpdate: (String) -> Unit,
    onSelectedLoadoutType: (SelectedLoadoutType) -> Unit,
) {
    LoadoutFromUrl(loadout = loadout, onLoadoutUrlUpdate = onLoadoutUrlUpdate)

    Column {
        LoadoutCard(
            modifier = Modifier.wrapContentSize(),
            loadout = loadout,
            onSelectedLoadoutType = onSelectedLoadoutType
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                GearStylizedText(text = "Discord : ")
                ClickableText("https://discord.gg/xQHwDzRh67")
            }
            CopyButton(
                modifier = Modifier.padding(start = 8.dp),
                textToCopy = loadout.toQueryParams(),
                buttonText = {
                    GearStylizedText(text = "Copy Loadout")
                }
            )
        }
    }
}

@Composable
fun FlowRowScope.ItemListColumn(
    state: MainScreenModel.BuildScreenState.Success,
    loadout: Loadout,
    onUpdateHeadGear: (HeadGear) -> Unit,
    onUpdateChestGear: (ChestGear) -> Unit,
    onUpdateBootsGear: (BootsGear) -> Unit,
    onUpdateDrifter: (Drifter) -> Unit,
    onUpdateWeapon: (SelectedLoadoutType, WeaponGear) -> Unit,
    onUpdateModHead: (ArmorMod) -> Unit,
    onUpdateModChest: (ArmorMod) -> Unit,
    onUpdateModBoots: (ArmorMod) -> Unit,
    onUpdateWeaponMod: (WeaponMod) -> Unit,
    onUpdateConsumable: (Consumable) -> Unit,
) {
    val modifier =
        if (isCompact())
            Modifier.sizeIn(
                minWidth = 300.dp,
                maxWidth = 450.dp,
                minHeight = 700.dp,
                maxHeight = 1000.dp
            )
                .wrapContentSize()
        else if (isMedium())
            Modifier.sizeIn(
                minWidth = 300.dp,
                maxWidth = 450.dp,
                minHeight = 700.dp,
                maxHeight = 1000.dp
            )
                .wrapContentSize()
        else
            Modifier.sizeIn(
                maxWidth = 650.dp,
                minWidth = 400.dp,
                minHeight = 550.dp,
                maxHeight = 1000.dp,
            ).wrapContentSize()

    val categoryOptions = listOf(
        GearCategory.DRIFTER,
        GearCategory.WEAPON,
        GearCategory.ARMOR,
        GearCategory.MOD,
        GearCategory.CONSUMABLE
    )
    val selectedIndex = remember { mutableStateOf(0)}

    LaunchedEffect(loadout.selectedLoadoutType) {
        selectedIndex.value = when (loadout.selectedLoadoutType) {
            SelectedLoadoutType.MOD_WEAPON, SelectedLoadoutType.MOD_HEAD, SelectedLoadoutType.MOD_CHEST, SelectedLoadoutType.MOD_BOOTS -> 3
            SelectedLoadoutType.HEAD, SelectedLoadoutType.CHEST, SelectedLoadoutType.BOOTS -> 2
            SelectedLoadoutType.DRIFTER -> 0
            SelectedLoadoutType.CONSUMABLE -> 4
            else -> 1
        }
    }

    Column(
        modifier = modifier.padding(top = 12.dp, start = 16.dp, end = 16.dp).fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        GearStylizedCard {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Top
            ) {

                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
                ) {
                    categoryOptions.forEachIndexed { index, label ->
                        SegmentedButton(
                            onClick = { selectedIndex.value = index },
                            selected = index == selectedIndex.value,
                            label = {
                                Image(
                                    painter = painterResource(
                                        when (label) {
                                            GearCategory.ARMOR -> Res.drawable.Com_Head_Helmet
                                            GearCategory.WEAPON -> Res.drawable.Com_Weapon_Sword
                                            GearCategory.DRIFTER -> Res.drawable.Common_ParagonWarehouse
                                            GearCategory.MOD -> Res.drawable.ItemIcon_MODCore
                                            GearCategory.CONSUMABLE -> Res.drawable.equip_medicine_4_3
                                        }
                                    ),
                                    colorFilter = ColorFilter.tint(Color.White),
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp)
                                )
                            },
                            shape = RectangleShape,
                            colors = SegmentedButtonColors(
                                activeBorderColor = WarborneColorTheme.borderSkillHightlightColor,
                                activeContainerColor = WarborneColorTheme.textBackgroundColor,
                                activeContentColor = WarborneColorTheme.textDescriptionColor,
                                inactiveBorderColor = WarborneColorTheme.borderSkillColor,
                                inactiveContainerColor = WarborneColorTheme.textBackgroundColor,
                                inactiveContentColor = WarborneColorTheme.borderSkillColor,
                                disabledActiveContainerColor = WarborneColorTheme.textBackgroundColor,
                                disabledActiveContentColor = WarborneColorTheme.textBackgroundColor,
                                disabledActiveBorderColor = WarborneColorTheme.textBackgroundColor,
                                disabledInactiveContainerColor = WarborneColorTheme.textBackgroundColor,
                                disabledInactiveContentColor = WarborneColorTheme.textBackgroundColor,
                                disabledInactiveBorderColor = WarborneColorTheme.textBackgroundColor,
                            )
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (categoryOptions[selectedIndex.value]) {
                        GearCategory.ARMOR -> {
                            Box(Modifier.wrapContentHeight()) {
                                ArmorSmallList(
                                    modifier = Modifier,
                                    data = state.data,
                                    loadout = loadout,
                                    onUpdateHeadGear = onUpdateHeadGear,
                                    onUpdateChestGear = onUpdateChestGear,
                                    onUpdateBootsGear = onUpdateBootsGear,
                                )
                            }
                        }

                        GearCategory.WEAPON -> {
                            WeaponSmallList(
                                modifier = Modifier,
                                loadout = loadout,
                                data = state.data.weapons,
                                onUpdateWeapon = onUpdateWeapon,
                            )
                        }

                        GearCategory.DRIFTER -> {
                            DrifterSmallList(
                                modifier = Modifier,
                                drifters = listOf(
                                    state.data.drifters.strDrifters,
                                    state.data.drifters.dexDrifters,
                                    state.data.drifters.intDrifters,
                                    state.data.drifters.gathers
                                ).flatten(),
                                onDrifterClick = { drifter: Drifter ->
                                    onUpdateDrifter(drifter)
                                })
                        }


                        GearCategory.CONSUMABLE -> {
                            ConsumableSmallList(
                                modifier = Modifier,
                                consumables = listOf(
                                    state.data.consumables.potions,
                                    state.data.consumables.food,
                                    state.data.consumables.poisons,
                                    state.data.consumables.utilities
                                ).flatten(),
                                onConsumableClick = { consumable: Consumable ->
                                    onUpdateConsumable(consumable)
                                }
                            )
                        }

                        GearCategory.MOD -> {
                            ModSmallList(
                                modifier = Modifier,
                                selectedLoadoutType = loadout.selectedLoadoutType,
                                data = state.data.mods,
                                onModClick = { category, mod ->
                                    when (mod) {
                                        is ArmorMod -> {
                                            when (category) {
                                                ModCategory.HEAD -> {
                                                    onUpdateModHead(mod)
                                                }

                                                ModCategory.CHEST -> {
                                                    onUpdateModChest(mod)
                                                }

                                                ModCategory.BOOTS -> {
                                                    onUpdateModBoots(mod)
                                                }

                                                else -> {}
                                            }
                                        }

                                        is WeaponMod -> {
                                            onUpdateWeaponMod(mod)
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FlowRowScope.DescriptionColumn(
    loadout: Loadout,
) {
    val modifier = if (isCompact())
        Modifier.fillMaxSize().padding(16.dp)
    else if (isMedium())
        Modifier.wrapContentHeight().weight(1f).padding(16.dp)
    else
        Modifier.sizeIn(
            minWidth = 300.dp,
            maxWidth = 600.dp,
        ).wrapContentHeight().weight(1f).padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)

    CardContainer(modifier = modifier) {
        when (loadout.selectedLoadoutType) {
            SelectedLoadoutType.DRIFTER -> DrifterCard(loadout.drifter)

            SelectedLoadoutType.HEAD -> ArmorCard(loadout.head, ArmorSlot.HEAD)
            SelectedLoadoutType.CHEST -> ArmorCard(loadout.chest, ArmorSlot.CHEST)
            SelectedLoadoutType.BOOTS -> ArmorCard(loadout.boots, ArmorSlot.BOOTS)
            SelectedLoadoutType.WEAPON,
            SelectedLoadoutType.BASIC_ATTACK,
            SelectedLoadoutType.COMMON_SKILL,
            SelectedLoadoutType.PASSIVE -> WeaponCard(
                loadout.weapon,
                selectedLoadoutType = loadout.selectedLoadoutType
            )

            SelectedLoadoutType.MOD_WEAPON -> ModCard(mod = loadout.weaponMod)
            SelectedLoadoutType.MOD_HEAD -> ModCard(mod = loadout.headMod)
            SelectedLoadoutType.MOD_CHEST -> ModCard(mod = loadout.chestMod)
            SelectedLoadoutType.MOD_BOOTS -> ModCard(mod = loadout.bootsMod)
            SelectedLoadoutType.CONSUMABLE -> ConsumableCard(consumable = loadout.consumable)
        }
    }
}