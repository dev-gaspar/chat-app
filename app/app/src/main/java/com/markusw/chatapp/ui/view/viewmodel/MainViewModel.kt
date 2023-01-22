package com.markusw.chatapp.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {

    private var _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    fun onUserNameChanged(userName: String) {
        _userName.value = userName
    }

}