package com.example.newUiKit.newScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.EventCardWide
import com.example.newUiKit.NewMolecules.UserAvatar
import com.example.newUiKit.SwitchItem
import com.example.newUiKit.Tags.BigTag
import com.example.newUiKit.Tags.MediumTag
import com.example.newUiKit.Tags.SmallTag
import com.example.newUiKit.newInputFields.NewTextInputView
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorGradient
import com.example.newUiKit.newTheme.multiColorGradientWhite
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.NewCustomButton
import kotlinx.coroutines.delay


@Composable
fun NewUiKitScreen(modifier: Modifier = Modifier, navController: NavController) {
    var isLoading by remember { mutableStateOf(false) }
    var isSwitchChecked by remember { mutableStateOf(true) }
// Состояния для каждого тега
    var isSmallTagSelected by remember { mutableStateOf(false) }
    var isMediumTagSelected by remember { mutableStateOf(false) }
    var isBigTagSelected by remember { mutableStateOf(false) }
    // `LaunchedEffect` находится на верхнем уровне
    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000) // Задержка в 2 секунды
            isLoading = false
        }
    }

    LazyColumn(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            SwitchItem(
                checked = isSwitchChecked,
                onCheckedChange = { isSwitchChecked = it }
            )
        }
        item {
            NewCustomButton(
                content = { Text(text = "Оплатить") },
                textColor = Color.White,
                enabledGradient = multiColorGradient(),
                disabledColor = MyUiTheme.colors.newOffWhite,
                enabled = true,
                isLoading = isLoading,
                onClick = {
                    isLoading = true
                }
            )
        }
        item {
            NewCustomButton(
                content = { Text(text = "Оплатить") },
                textColor = MyUiTheme.colors.newBrandDefault,
                enabledGradient = multiColorGradientWhite(),
                disabledColor = MyUiTheme.colors.newOffWhite,
                enabled = true,
                isLoading = isLoading,
                onClick = {
                    isLoading = false
                }
            )
        }
        item {
            NewCustomButton(
                content = { Text(text = "Оплатить") },
                textColor = MyUiTheme.colors.newBrandDefault,
                enabledGradient = multiColorGradientWhite(),
                disabledColor = MyUiTheme.colors.newOffWhite,
                enabled = false,
                isLoading = isLoading,
                onClick = {
                    isLoading = false
                }
            )
        }
        item {
            NewCustomButton(
                content = { Text(text = "Оплатить") },
                textColor = Color.White,
                enabledGradient = multiColorGradient(),
                disabledColor = MyUiTheme.colors.newOffWhite,
                enabled = true,
                isLoading = isLoading,
                onClick = {
                    isLoading = false
                }
            )
        }
        item {
            NewTextInputView {}
        }
        item {
            MediumTag(
                text = "Тестирование",
                isSelected = isMediumTagSelected,
                onSelectedChange = { isMediumTagSelected = it })
            BigTag(
                text = "Дизайн",
                isSelected = isBigTagSelected,
                onSelectedChange = { isBigTagSelected = it })
            SmallTag(
                text = "Тестирование",
                isSelected = isSmallTagSelected,
                onSelectedChange = { isSmallTagSelected = it })

        }
        item {
            UserAvatar(
                imageUrl = "https://s3-alpha-sig.figma.com/img/fa6d/f816/18a1e0468b6f5978e2adb058a64935e6?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=kVYVZrIPvXSXMi4J8hfzMgICf6N25qN-mDsq4me18K7YjnMoTvONxhNu9LZvfTOqy02wnHmnrbTXCPOCbDQcxq77OnfHJ1SX12V3nGwB20~KY~66k7v8J8pGd06XlGjDOl4KsAsOUQ58B8wqdqaRJO3ddQtbbJVKxDFoMrcCE3Ni~oB-EMot3jldWrncMbiWdAnXCSCOPfwh7emYIUXLPlHcGNCq8Q7kne9dmBE0AAuMFWcs6Hwm8LVcBKiwBNDLoyngHWJqJCKQBLg1iut~t2dLELDk0MRbfFSYCbG~~9RQlaQBlgsfAiFA-KO4gof0~lDvxQ0AuXTD4EZHV26DeA_",
//                avatarResId = R.drawable.test_avatar_user,
                isEditing = false,
                modifier = Modifier.padding(16.dp),
                size = 230.dp
            )
        }
        item {
            EventCardWide(
                title = "Python days",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                painter = painterResource(id = R.drawable.pythondays),
                date = "10 августа",
                location = "Кожевенная линия, 40",
                isFinished = true,
                onClick = {})
        }
    }
}
