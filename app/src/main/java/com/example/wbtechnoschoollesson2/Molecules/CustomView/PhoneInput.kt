package com.example.wbtechnoschoollesson2.Molecules.CustomView

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme

private const val PHONE_NUMBER_SIZE = 10

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhoneInput(modifier: Modifier = Modifier, onPhoneChange: (String) -> Unit) {
    var selectedCountry by remember { mutableStateOf(Country.Russia) }
    var phone by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(UiTheme.colors.neutralSecondaryBg)
                .padding(vertical = 16.dp)
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(horizontal = 8.dp),
                painter = painterResource(id = selectedCountry.flagPainterId),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = selectedCountry.phoneCode,
                style = UiTheme.typography.bodyText1,
                color = UiTheme.colors.neutralDisabled
            )
        }

        DropdownMenu(
            modifier = Modifier
                .background(UiTheme.colors.neutralSecondaryBg),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Country.entries.forEach { country ->
                DropdownMenuItem(
                    modifier = Modifier
                        .background(UiTheme.colors.neutralSecondaryBg),
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Icon(
                                painter = painterResource(id = country.flagPainterId),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                            Text(
                                text = country.phoneCode,
                                style = UiTheme.typography.bodyText1,
                                color = UiTheme.colors.neutralDisabled
                            )
                        }
                    },
                    onClick = {
                        selectedCountry = country
                        expanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.size(8.dp))

        BasicTextField(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(UiTheme.colors.neutralSecondaryBg)
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            value = phone,
            onValueChange = {
                phone = it.take(PHONE_NUMBER_SIZE)
                onPhoneChange(selectedCountry.phoneCode + phone)
            },
            textStyle = UiTheme.typography.bodyText1,
            decorationBox = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(UiTheme.colors.neutralSecondaryBg)
                ) {
                    if (phone.isEmpty())
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = "999 999-99-99",
                            style = UiTheme.typography.bodyText1,
                            color = UiTheme.colors.neutralDisabled
                        )
                    it()
                }
            },
            visualTransformation = PhoneNumberTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                    onPhoneChange(selectedCountry.phoneCode + phone)
                }
            ),
        )
    }
}

@Composable
@Preview
fun PhoneInputPreview() {
    PhoneInput() {}
}