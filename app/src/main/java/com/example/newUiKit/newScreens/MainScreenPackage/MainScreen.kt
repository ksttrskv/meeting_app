package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.NewMolecules.Banner
import com.example.newUiKit.NewMolecules.CommunityCard
import com.example.newUiKit.NewMolecules.EventCardThin
import com.example.newUiKit.NewMolecules.EventCardWide
import com.example.newUiKit.NewMolecules.NewHeading
import com.example.newUiKit.NewMolecules.PersonCard
import com.example.newUiKit.Tags.BigTagsList
import com.example.newUiKit.newInputFields.WbSearchView
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R


@Composable
fun MainScreen(navController: NavController) {

    val tags = listOf(
        "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
        "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
        "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
    )

    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    Row {
                        WbSearchView()
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.user_icon),
                            contentDescription = "user icon"
                        )
                    }
                    LazyRow {
                        item {
                            EventCardWide(
                                title = "QA Talks — Global tech forum",
                                textStyle = MyUiTheme.typography.H1,
                                painter = painterResource(id = R.drawable.eventcard_testimage),
                                date = "Завтра",
                                location = "Невский проспект, 11",
                                onClick = {},
                                modifier = Modifier.width(320.dp)
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.width(10.dp))
                            EventCardWide(
                                title = "QA Talks — Global",
                                textStyle = MyUiTheme.typography.H1,
                                painter = painterResource(id = R.drawable.image_test_3),
                                date = "Завтра",
                                location = "Невский проспект, 11",
                                onClick = {},
                                modifier = Modifier.width(320.dp)
                            )
                        }
                    }
                }
            }
            item {
                Column {
                    NewHeading(text = "Ближайшие встречи")
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        item {
                            EventCardThin(
                                title = "Python days",
                                painter = painterResource(id = R.drawable.pythondays),
                                date = "10 августа",
                                location = "Кожевенная линия, 40",
                                onClick = {})
                        }
                        item {
                            EventCardThin(
                                title = "Турнир разработчиков «Белые ночи»",
                                painter = painterResource(id = R.drawable.image_test_4),
                                date = "10 августа",
                                location = "Кожевенная линия, 40",
                                onClick = {})
                        }
                    }
                }
            }
            item {
                Column {
                    NewHeading(text = "Сообщества для тестировщиков")
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
                                onClick = {})
                        }
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
                                onClick = {})
                        }
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
                                onClick = {})
                        }
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
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
            }
            item {
                Column {
                    NewHeading(text = "Другие встречи")

                    Spacer(modifier = Modifier.height(16.dp))

                    BigTagsList(tags = tags)
                }
            }

            item {
                EventCardWide(
                    title = "Как повышать грейд. Лекция Павла Хорикова",
                    painter = painterResource(id = R.drawable.test_image_6),
                    date = "Завтра",
                    location = "Невский проспект, 11",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )


            }
            item {
                EventCardWide(
                    title = "Андроидкор QA 2024",
                    painter = painterResource(id = R.drawable.test_image_5),
                    date = "Завтра",
                    location = "Невский проспект, 11",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                EventCardWide(
                    title = "Путь в IT для школьников",
                    painter = painterResource(id = R.drawable.test_image_2),
                    date = "18 августа",
                    location = "наб. канала Грибоедова, 133",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Banner()
            }
            item {
                EventCardWide(
                    title = "Дизайн-встреча s8e2",
                    painter = painterResource(id = R.drawable.test_image_1),
                    date = "10 августа ",
                    location = "Литейный проспект, 46",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                EventCardWide(
                    title = "Офлайн-интенсив по брендингу",
                    painter = painterResource(id = R.drawable.test_image_3),
                    date = "8 августа ",
                    location = "ул. Улица Марата, 58 / Разъезжая,29",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                EventCardWide(
                    title = "Просмотр",
                    painter = painterResource(id = R.drawable.test_image_4),
                    date = "8 августа",
                    location = "ул. Малая Садовая, 2",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Column {
                    NewHeading(text = "Вы можете их знать")
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        item {
                            PersonCard(
                                title = "Мария",
                                painter = painterResource(id = R.drawable.user_avatar),
                                onClick = {}
                            )
                        }
                        item {
                            PersonCard(
                                title = "Ирина",
                                painter = painterResource(id = R.drawable.user_avatar),
                                onClick = {}
                            )
                        }
                        item {
                            PersonCard(
                                title = "Никита",
                                painter = painterResource(id = R.drawable.user_avatar),
                                onClick = {}
                            )
                        }
                        item {
                            PersonCard(
                                title = "Илья",
                                painter = painterResource(id = R.drawable.user_avatar),
                                onClick = {}
                            )
                        }
                        item {
                            PersonCard(
                                title = "Кутакбах",
                                painter = painterResource(id = R.drawable.user_avatar),
                                onClick = {}
                            )
                        }
                    }
                }
            }
            item {
                EventCardWide(
                    title = "Как повышать грейд. Лекция Павла Хорикова",
                    painter = painterResource(id = R.drawable.test_image_6),
                    date = "Завтра",
                    location = "Невский проспект, 11",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )


            }
            item {
                EventCardWide(
                    title = "Андроидкор QA 2024",
                    painter = painterResource(id = R.drawable.test_image_5),
                    date = "Завтра",
                    location = "Невский проспект, 11",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                EventCardWide(
                    title = "Путь в IT для школьников",
                    painter = painterResource(id = R.drawable.test_image_2),
                    date = "18 августа",
                    location = "наб. канала Грибоедова, 133",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }


            item {
                Column {
                    NewHeading(text = "Сообщества для тестировщиков")
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
                                onClick = {})
                        }
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
                                onClick = {})
                        }
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
                                onClick = {})
                        }
                        item {
                            CommunityCard(
                                title = "Супер тестировщики",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
                                painter = painterResource(id = R.drawable.zapuskaem_gus),
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
            }
            item {
                EventCardWide(
                    title = "Как повышать грейд. Лекция Павла Хорикова",
                    painter = painterResource(id = R.drawable.test_image_6),
                    date = "Завтра",
                    location = "Невский проспект, 11",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )


            }
            item {
                EventCardWide(
                    title = "Андроидкор QA 2024",
                    painter = painterResource(id = R.drawable.test_image_5),
                    date = "Завтра",
                    location = "Невский проспект, 11",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                EventCardWide(
                    title = "Путь в IT для школьников",
                    painter = painterResource(id = R.drawable.test_image_2),
                    date = "18 августа",
                    location = "наб. канала Грибоедова, 133",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}
//}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MyMeetingAppTheme {
        MainScreen(navController = navController)
    }
}