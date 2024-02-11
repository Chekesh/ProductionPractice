package com.example.martialartsschool

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.martialartsschool.ui.theme.AppTheme
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import java.time.LocalDate

class Calendar : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(
                    Modifier
                        .background(Color.Black)
                        .fillMaxSize(),
                    topBar = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Black)
                        ) {
                            androidx.compose.material3.Text(
                                text = "Личный кабинет",
                                color = Color.Blue,
                                fontSize = 30.sp,
                                modifier = Modifier.padding(vertical = 20.dp)
                            )
                        }
                    },
                    bottomBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFDDDDDD)),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(7.dp), horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Box(modifier = Modifier.clickable {
                                    val intent = Intent(this@Calendar, ClientActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }) {
                                    Icon(
                                        imageVector = Icons.Outlined.Home,
                                        contentDescription = "homeScreen",
                                        Modifier.size(30.dp),
                                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                                Box(modifier = Modifier.clickable {
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.CalendarToday,
                                        contentDescription = "Calendar icon",
                                        Modifier.size(30.dp),
                                        tint = Color(0xFF0066FF)
                                    )
                                }

                            }
                        }

                    }
                ) {
                    val calendarState = rememberSelectableCalendarState()
                    Column(
                        Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(top = 100.dp)
                    ) {
                        SelectableCalendar(calendarState = calendarState)
                        if (calendarState.selectionState.selection.joinToString { it.toString() } in Date.array) {
                            val date1 = LocalDate.now()
                            val date2 = LocalDate.now().plusDays(1)
                            val comparison = date1.compareTo(date2)
                            when {
                                comparison < 0 -> Massag(true)
                                comparison > 0 -> println("$date1 больше, чем $date2")
                                else -> println("$date1 и $date2 равны")
                            }
                        } else {
                            Massag(false)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Massag(bol: Boolean) {
        Box(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFAFFFFFF),
                            Color(0xFFFF0000),
                            Color(0xFF000000)
                        )
                    ), shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = if (bol) "     Сегодня есть тренировка!!!\n Ваш ребенок будет на занятии?" else "В этот день нет тренировки",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(vertical = 45.dp)
                )
            }
        }
        if (bol) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .padding(top = 15.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF000000),
                                Color(0xFFFF0000),
                                Color(0xFF000000)
                            )
                        ), shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    Modifier
                        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    for (i in 1..2) {
                        ElevatedButton(
                            onClick = {
                            },
                            modifier = Modifier.fillMaxWidth(0.7f),
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = Color(0x723364F7)
                            )
                        ) {
                            Text(
                                text = if (i == 1) "Будет присутсвовать " else "Будет отсутсвовать ",
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    }
                }

            }
        }
    }
}
