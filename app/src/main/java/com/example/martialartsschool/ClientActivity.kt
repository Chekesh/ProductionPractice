package com.example.martialartsschool

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.martialartsschool.ui.theme.AppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.CalendarToday


class ClientActivity : ComponentActivity() {
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
                            Text(
                                text = "Личный кабинет",
                                color = Color.Blue,
                                fontSize = 30.sp,
                                modifier = Modifier.padding(vertical = 20.dp)
                            )
                        }
                    },
                    bottomBar = {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFDDDDDD)), contentAlignment = Alignment.BottomCenter){
                            Row(
                                Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(7.dp), horizontalArrangement = Arrangement.SpaceAround){
                                Box(){
                                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "homeScreen", Modifier.size(30.dp), tint = Color(0xFF0066FF))
                                }
                                Box(modifier = Modifier.clickable {
                                    val intent = Intent(this@ClientActivity, Calendar::class.java)
                                    startActivity(intent)
                                    finish()
                                }){
                                    Icon(imageVector = Icons.Filled.CalendarToday, contentDescription = "Calendar icon", Modifier.size(30.dp), tint = MaterialTheme.colorScheme.onPrimaryContainer)
                                }

                            }
                        }

                    }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 100.dp)
                    ) {
                        //height()) {
                        Boxhuman("Ребенок", "Казаков Виталя Андреевич", "20.08.2009", "Бокс", "21ИТ17")
                        Spacer(modifier = Modifier.height(25.dp))
                        Boxhuman("Тренер", "Чекшин Никита Сергеевич", "27.02.1990", "Бокс", "21ИТ17, 22ИТ34, 19ИТ23")


                    }
                }
            }
        }
    }

    @Composable
    fun Boxhuman(rol: String, FIO: String, age: String, section: String, group: String) {
        Text(text = rol, fontSize = 20.sp)
        //Column(horizontalAlignment = Alignment.CenterHorizontally,
        //modifier = Modifier.fillMaxWidth().padding(top = 100.dp)){
        Box(
            modifier = Modifier
                .padding(20.dp)
                .background(Brush.horizontalGradient(colors = listOf(
                    //Color(0xFF007BFF),
                    //Color(0xFF88FF33)
                    Color(0xFAFFFFFF),
                    Color(0xFFFF0000),
                    Color(0xFF000000))), shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
                Text(text = FIO,
                    fontSize = 15.sp,
                modifier = Modifier.padding(top = 15.dp))
                Text(text = age.toString(), fontSize = 15.sp, modifier = Modifier.padding(top = 15.dp))
                Text(text = section, fontSize = 15.sp, modifier = Modifier.padding(top=15.dp))
                Text(text = group, fontSize = 15.sp, modifier = Modifier.padding(top = 15.dp))
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}
