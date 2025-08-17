package com.example.jetpackdemo.ui.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.jetpackdemo.viewmodel.ApiViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ProfileScreen(viewModel: ApiViewModel) {

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

