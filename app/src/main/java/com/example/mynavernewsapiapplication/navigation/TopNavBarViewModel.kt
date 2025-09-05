package com.example.mynavernewsapiapplication.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TopNavBarViewModel: ViewModel() {
    private val _userQuery = MutableStateFlow<String>("")
    val userQuery: StateFlow<String> = _userQuery.asStateFlow()

    fun updateUserQuery(newQuery: String) {
        _userQuery.value = newQuery
    }
}
