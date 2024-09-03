package com.example.newUiKit.NewMolecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.combinedGradient
import com.example.newUiKit.newTheme.multiColorComplexGradient
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


@Composable
fun LogoWithBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(brush = multiColorComplexGradient(), shape = RoundedCornerShape(22.dp))
            .background(brush = combinedGradient(), shape = RoundedCornerShape(22.dp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.wb_events_logo),
            contentDescription = "wb встречи",
            modifier = modifier.padding(horizontal = 10.dp, vertical = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogoWIthBg() {
    WBTechnoschoolLesson2Theme {
        LogoWithBackground()
    }
}