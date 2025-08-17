package com.example.jetpackdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackdemo.data.repository.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ApiViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _data = MutableStateFlow<String?>(null)
    val data: StateFlow<String?> = _data.asStateFlow()

    fun fetchData() {
        Log.i("fetchData", "fetchData")
        viewModelScope.launch {
            try {
                Log.i("apiService.getData()", apiService.getData())
                _data.value = apiService.getData()
            } catch (e: Exception) {
                // 错误处理
                Log.i("err:", e.toString())
            }
        }
    }
}