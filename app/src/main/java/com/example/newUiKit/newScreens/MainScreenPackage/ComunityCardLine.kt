package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.CommunityCard
import com.example.wbtechnoschoollesson2.R

@Composable
fun CommunityCardLine() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        item {
            CommunityCard(
                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                painter = painterResource(id = R.drawable.zapuskaem_gus),
                onClick = {},
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            CommunityCard(
                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                painter = painterResource(id = R.drawable.image_test_4),
                onClick = {})
        }
        item {
            CommunityCard(
                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                painter = painterResource(id = R.drawable.image_test_3),
                onClick = {})
        }
        item {
            CommunityCard(
                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                painter = painterResource(id = R.drawable.test_image_2),
                onClick = {})
        }
        item {
            CommunityCard(
                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                painter = painterResource(id = R.drawable.zapuskaem_gus),
                onClick = {})
        }
    }
}