package com.example.jetpackdemo.ui.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackdemo.viewmodel.ApiViewModel
import kotlin.properties.ReadOnlyProperty
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ApiScreen(viewModel: ApiViewModel = hiltViewModel()) {
    val data: String? by viewModel.data.collectAsState()

    Column {
        Button(onClick = { viewModel.fetchData() }) {
            Text("获取数据")
        }

        data?.let {
            Text(text = it)
        }
    }
}

