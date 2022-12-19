package com.dimasrizqi.challenge7.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimasrizqi.challenge7.data.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(val dataStoreManager: DataStoreManager): ViewModel() {
    fun saveAccount(username: String, password: String, email: String) {
        viewModelScope.launch {
            dataStoreManager.setUsername(username)
            dataStoreManager.setPassword(password)
            dataStoreManager.setEmail(email)
        }
    }
}