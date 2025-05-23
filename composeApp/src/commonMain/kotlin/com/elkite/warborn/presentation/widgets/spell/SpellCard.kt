package com.elkite.warborn.presentation.widgets.spell

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.gear.ArmorImage
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText


@Composable
fun SpellCardList(
    modifier: Modifier = Modifier,
    spells: List<Spell>,
    onSpellClick: (Spell) -> Unit,
) {
    Column(
        modifier = modifier.width(600.dp).background(color = Color.Transparent).padding(horizontal = 16.dp),
    ) {
        spells.forEach { spell ->
            Spacer(Modifier.size(12.dp))
            SpellCard(onSpellClick, spell)
            Spacer(Modifier.size(12.dp))
        }
    }
}

@Composable
fun SpellCard(
    onSpellClick: (Spell) -> Unit,
    spell: Spell
) {
    GearStylizedCard(
        modifier = Modifier.clickable { onSpellClick(spell) },
        composable = @Composable { SpellCardContent(spell) },
    )
}

@Composable
fun SpellCardContent(spell: Spell) {
    Column(
        modifier = Modifier.wrapContentSize().padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
        ) {
            SpellIcon(
                Modifier.size(64.dp).border(
                    1.dp,
                    color = WarborneTheme.borderSkillColor,
                ), gearType = spell.associatedGearType, spellType = spell.type, id = spell.gameId
            )
            Spacer(Modifier.size(16.dp))
            GearStylizedTextTitle(text = spell.name)
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
            color = WarborneTheme.borderSkillColor,
            thickness = 1.dp
        )
        SpellAttributes(spell)
        Spacer(Modifier.size(16.dp))
        MultiPatternHighlightedText(
            baseTextStyle = MaterialTheme.typography.body1.copy(color = WarborneTheme.textDescriptionColor).copy(
                    fontFamily = FontFamily.Monospace
                    ),
            text = spell.description,
            patternsWithStyles = listOf(
                Regex("""\[Damage Rate: [^\]]+]""") to SpanStyle(
                    color = WarborneTheme.textDamageColor,
                    fontWeight = FontWeight.Bold
                ),
                Regex("""\[Healing Rate: [^\]]+]""") to SpanStyle(
                    color = WarborneTheme.textHealColor,
                    fontWeight = FontWeight.Bold
                ),
                Regex("""\[Target-based Max HP [^\]]+]""") to SpanStyle(
                    color = WarborneTheme.textShieldColor,
                    fontWeight = FontWeight.Bold
                )
            )
        )
        Spacer(Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

            ) {
            if (!spell.gearName.isNullOrEmpty() && spell.associatedGearType != GearType.DRIFTER) {
                ArmorImage(gearName = spell.gearName, gearType = spell.associatedGearType, rarity = spell.rarity)
                Spacer(Modifier.size(16.dp))
            }
            GearStylizedText(
                text = if (spell.gearName.isNullOrEmpty()) "Skill available at ${spell.requiredGearLevel.textValue} and above."
                else "Skill available at ${spell.requiredGearLevel.textValue} and above for ${spell.gearName}",
                maxLines = 2
            )
        }
    }
}

@Composable
fun SpellAttributes(spell: Spell) {
    val attributes = mutableListOf<Pair<String, String>>()

    if (spell.manaCost.isNotEmpty()) {
        attributes.add("Mana: " to spell.manaCost)
    }
    if (spell.cooldown.isNotEmpty()) {
        attributes.add("Cooldown: " to "${spell.cooldown}s")
    }
    if (spell.castingRange.isNotEmpty()) {
        attributes.add("Range: " to "${spell.castingRange} m")
    }

    AttributeList(attributes = attributes)
}




