package com.codelap.waglegamoon.ui.profile.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import com.codelap.waglegamoon.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _defaultResult = MutableStateFlow(DefaultResponse())
    val defaultResult: StateFlow<DefaultResponse> = _defaultResult

    fun postUsers() {
        viewModelScope.launch {
            repository.postUsers(UserSavedRequest("Tnalxmsk", "MALE", 19990502, false,
                listOf("대면"),"컴퓨터공학과", "코딩")
            ).collectLatest {
                _defaultResult.value = it
            }
        }
    }
}