package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.Molecules.CustomView.PhoneInput
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.WbSolidButton
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.screens.ViewModels.LoginScreenViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun LoginScreen(navController: NavController, viewModel: LoginScreenViewModel = koinViewModel()) {
//    var phone by remember { mutableStateOf("") }
    val userPhoneInput by viewModel.userPhoneInput.collectAsState()

    Box(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp)
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopStart
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 168.dp)
                .background(Color.White)
        ) {
            item {
                Text(
                    text = stringResource(R.string.loginscreen_inputphone),
                    style = UiTheme.typography.subheading2,
                    fontSize = 24.sp,
                    color = UiTheme.colors.neutralActive,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(8.dp))
            }

            item {
                Text(
                    text = stringResource(R.string.loginscreen_we_send_code),
                    style = UiTheme.typography.bodyText2,
                    color = UiTheme.colors.neutralActive,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(48.dp))
            }
            item {
                PhoneInput(onPhoneChange = viewModel::onPhoneChanged)
                Spacer(modifier = Modifier.size(68.dp))
            }
            item {
                WbSolidButton(
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        Text(
                            text = stringResource(R.string.continue_button),
                            style = UiTheme.typography.subheading2,
                            color = UiTheme.colors.neutralOffWhite
                        )
                    },
                    btnColor = UiTheme.colors.brandColorDefault,
                    textColor = UiTheme.colors.neutralOffWhite,
                    onClick = {
                        navController.navigate(Screens.CodeInput)
                    },
                    enabled = userPhoneInput.isNotBlank()
                )
            }
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    WBTechnoschoolLesson2Theme {
//        val navContoller = rememberNavController()
//        LoginScreen(navController = navContoller)
//
//    }
//}



