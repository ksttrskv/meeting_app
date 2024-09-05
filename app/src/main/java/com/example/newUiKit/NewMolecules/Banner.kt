package com.example.newUiKit.NewMolecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newButtons.NewSolidButton
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.combinedGradient
import com.example.newUiKit.newTheme.multiColorComplexGradient
import com.example.newUiKit.newTheme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(brush = multiColorComplexGradient(), shape = RoundedCornerShape(16.dp))
            .background(brush = combinedGradient(), shape = RoundedCornerShape(16.dp))
            .fillMaxWidth(),
//            .width(344.dp),
//        contentAlignment = Alignment.CenterEnd
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
        {
//            Spacer(modifier = Modifier.height(10.dp))
            Text(
//                modifier = Modifier.padding(top = 10.dp),
                text = "Расскажите о своих интересах, \nчтобы мы рекомендовали \nполезные встречи",
                style = MyUiTheme.typography.Secondary,
                color = Color.White,


                )
            NewSolidButton(
                content = {
                    Text(
                        text = "Выбрать интересы",
                        style = MyUiTheme.typography.H5,
                        color = MyUiTheme.colors.newBrandDefault
                    )
                },
                enabledGradient = multiColorLinearGradientWhite(),
                onClick = {},
            )
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.strelka_left),
                contentDescription = "",
//                modifier = modifier.padding(vertical = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.strelka_right),
                contentDescription = "",
//                modifier = modifier.padding(vertical = 10.dp)
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBanner() {
    WBTechnoschoolLesson2Theme {
        Banner()
    }
}