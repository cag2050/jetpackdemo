package com.example.jetpackdemo

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class KtorTest {

    suspend fun gitUserTest() {
        coroutineScope {
            launch {
                val client = HttpClient(CIO)
                val response: HttpResponse = client.get("https://api.github.com/users/cag2050")
                println(response)
                client.close()
            }
        }
    }

    @Test
    fun callGitUserTest() {
        runBlocking { gitUserTest() }
    }
}