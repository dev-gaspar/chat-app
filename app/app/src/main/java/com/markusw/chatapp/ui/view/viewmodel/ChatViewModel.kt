package com.markusw.chatapp.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(

): ViewModel() {

    private var _messageText = MutableStateFlow("")
    val messageText = _messageText.asStateFlow()

    fun onMessageTextChanged(text: String) {
        _messageText.value = text
    }

}