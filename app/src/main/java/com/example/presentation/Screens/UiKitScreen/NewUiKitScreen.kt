package com.example.presentation.Screens.UiKitScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.Theme.multiColorLinearGradient
import com.example.presentation.Theme.multiColorLinearGradientWhite
import com.example.presentation.inputFields.PhoneInputField.PhoneInput
import com.example.presentation.inputFields.TextInputView
import com.example.presentation.molecules.BigTag
import com.example.presentation.molecules.CommunityCard
import com.example.presentation.molecules.EventCardThin
import com.example.presentation.molecules.EventCardWide
import com.example.presentation.molecules.Logo
import com.example.presentation.molecules.LogoWithBackground
import com.example.presentation.molecules.MediumTag
import com.example.presentation.molecules.PersonCard
import com.example.presentation.molecules.SmallTag
import com.example.presentation.molecules.SwitchItem
import com.example.presentation.molecules.TopBar
import com.example.presentation.molecules.UserAvatar
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton
import kotlinx.coroutines.delay


@Composable
fun NewUiKitScreen(
    modifier: Modifier = Modifier, navController: NavController,
) {
    var isLoading by remember { mutableStateOf(false) }
    var isSwitchChecked by remember { mutableStateOf(true) }
// Состояния для каждого тега
    var isSmallTagSelected by remember { mutableStateOf(false) }
    var isMediumTagSelected by remember { mutableStateOf(false) }
    var isBigTagSelected by remember { mutableStateOf(false) }
    var isSubscribe by remember { mutableStateOf(false) }
    // `LaunchedEffect` находится на верхнем уровне
    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000) // Задержка в 2 секунды
            isLoading = false
        }
    }
    Scaffold(
        topBar = {
            TopBar(
                title = "Как повышать грейд. Лекция...",
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp),
                            tint = MyUiTheme.colors.brandDefault
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.share),
                            contentDescription = "Share",
                            modifier = Modifier.size(24.dp),
                            tint = MyUiTheme.colors.brandDefault
                        )
                    }
                }
            )

        },
        containerColor = Color.White

    ) { contentPadding ->
        LazyColumn(
            modifier = modifier
                .padding(contentPadding)
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
                CustomButton(
                    content = { Text(text = "Оплатить") },
                    textColor = Color.White,
                    enabledGradient = multiColorLinearGradient(),
                    disabledColor = MyUiTheme.colors.offWhite,
                    enabled = true,
                    isLoading = isLoading,
                    onClick = {
                        isLoading = true
                    }
                )
            }
            item {
                CustomButton(
                    content = { Text(text = "Оплатить") },
                    textColor = MyUiTheme.colors.brandDefault,
                    enabledGradient = multiColorLinearGradientWhite(),
                    disabledColor = MyUiTheme.colors.offWhite,
                    enabled = true,
                    isLoading = isLoading,
                    onClick = {
                        isLoading = false
                    }
                )
            }
            item {
                CustomButton(
                    content = { Text(text = "Оплатить") },
                    textColor = MyUiTheme.colors.brandDefault,
                    enabledGradient = multiColorLinearGradientWhite(),
                    disabledColor = MyUiTheme.colors.offWhite,
                    enabled = false,
                    isLoading = isLoading,
                    onClick = {
                        isLoading = false
                    }
                )
            }
            item {
                CustomButton(
                    content = { Text(text = "Оплатить") },
                    textColor = Color.White,
                    enabledGradient = multiColorLinearGradient(),
                    disabledColor = MyUiTheme.colors.offWhite,
                    enabled = true,
                    isLoading = isLoading,
                    onClick = {
                        isLoading = false
                    }
                )
            }
            item {
                TextInputView(onNameChange = {})
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
                    isEditing = false,
                    modifier = Modifier.padding(16.dp),
                    size = 230.dp
                )
            }
            item {
                EventCardWide(
                    title = "Python days",
                    imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                    date = "10 августа",
                    location = "Кожевенная линия, 40",
                    onClick = {})
            }
            item {
                EventCardThin(
                    title = "Python days",
                    imageUrl = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg",
                    date = "10 августа",
                    location = "Кожевенная линия, 40",
                    onClick = {})
            }
            item {
                CommunityCard(
                    title = "Супер тестировщики",
                    imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg",
                    onClick = {}
                )
            }
            item {
                PersonCard(
                    title = "Крис",
                    imageUrl = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
                    tag = "Developer"
                )
            }
            item {
                PhoneInput(onPhoneChange = {})
            }
            item {
                Logo()
            }
            item {
                LogoWithBackground()
            }
        }
    }
}