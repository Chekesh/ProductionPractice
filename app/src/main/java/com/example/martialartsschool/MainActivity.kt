package com.example.martialartsschool

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.martialartsschool.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Authorize()
            }
        }
    }
    @Composable
    fun Authorize() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            AuthorizeCenter()
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Ешё нет аккаунта?",
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "Зарегестрироваться",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.clickable {
                        Log.d(TAG, "Пользователь нажал на кнопку войти")
                        Toast.makeText(
                            this@MainActivity,
                            "Пользователь нажал на кнопку войти",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputText(value: MutableState<String>, placeholder: String) {
        TextField(
            value = value.value,
            onValueChange = { value.value = it },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
            placeholder = { Text(placeholder) },
            singleLine = true
        )
    }

    @Composable
    fun AuthorizeCenter() {
        val login = remember {
            mutableStateOf("")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight(0.3f)
        ) {
            Text(text = "Авторизация", fontSize = 34.sp, color = MaterialTheme.colors.primary)
            InputText(value = login, placeholder = "Логин")
            ElevatedButton(
                onClick = {
                    var truelogs: Boolean
                    if (Connection.Authorizations(login.value)) {
                        val intent = Intent(this@MainActivity, ClientActivity::class.java)
                        Log.d(TAG, "было")
                        startActivity(intent)
                    } else {
                        Log.d(TAG, "Отказ")
                        Toast.makeText(
                            this@MainActivity,
                            "Такого логина не существует",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(0.4f),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colors.primary
                )
            ) {
                Text("Войти", color = MaterialTheme.colors.onPrimary)
            }
        }
    }
}