package com.example.martialartsschool

import android.content.ContentValues
import android.util.Log
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*

class Connection {
    companion object {
        lateinit var person: Person
        val ID: String = "192.168.15.19"
        suspend fun Authorization(login: String): Boolean {
            val client = HttpClient(OkHttp)
            var result: Boolean
            try {
                val response: String = client.get(urlString = "http://$ID:8081/students/user/$login")
                person = Gson().fromJson(response, Person::class.java)
                result = true
            } catch (ex: IOException) {
                result = false
            } finally {
                client.close()
            }
            return result
        }
        fun Authorizations(login: String): Boolean {
            Log.d(ContentValues.TAG, login)
            //var result: Boolean = if(login == "Chekesh") true else false
            return if(login == "Chekesh") true else false
        }
        fun Group(){}
    }
}