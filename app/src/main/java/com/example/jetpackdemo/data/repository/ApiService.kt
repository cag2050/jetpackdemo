package com.example.jetpackdemo.data.repository

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import javax.inject.Inject

class ApiService @Inject constructor() {
    private val client = HttpClient(CIO)

    suspend fun getData(): String {
        Log.i("getData", "getData")
        val data = client.get("https://api.github.com/users/cag2050").toString()
        Log.i("data", data)
        return client.get("https://api.github.com/users/cag2050").toString()
    }
}