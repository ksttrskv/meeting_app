package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbtechnoschoollesson2.Molecules.CustomView.CodeInput
import com.example.wbtechnoschoollesson2.Molecules.CustomView.PhoneInput

@Composable
fun CustomViewScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column {
            PhoneInput(){}
            CodeInput(){}
        }

    }
}
@Composable
@Preview
fun PhoneInputPreview(){
    CustomViewScreen()
}