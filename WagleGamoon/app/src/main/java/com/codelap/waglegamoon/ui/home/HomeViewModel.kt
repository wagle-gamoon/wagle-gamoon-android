package com.codelap.waglegamoon.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.PostListResponse
import com.codelap.waglegamoon.domain.model.PostSaveDto
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import com.codelap.waglegamoon.domain.repository.HomeRepository
import com.codelap.waglegamoon.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val repository: HomeRepository,
    private val profileRepository: UserRepository
) : ViewModel() {
    private val _postResult = MutableStateFlow(DefaultResponse())
    val postResult: StateFlow<DefaultResponse> = _postResult
    private val _defaultResult = MutableStateFlow(DefaultResponse())
    val defaultResult: StateFlow<DefaultResponse> = _defaultResult
    private val _postList = MutableStateFlow(PostListResponse(data = emptyList()))
    val postList: StateFlow<PostListResponse> = _postList

    fun postPosts(
        userId: Long, categorySort: String, title: String,
        place: String, content: String, totalCount: Int, currentCount: Int
    ) {
        viewModelScope.launch {
            try {
                repository.postPosts(
                    userId,
                    PostSaveDto(categorySort, title, place, content, totalCount, currentCount)
                ).collect {
                    _postResult.value = it
                }
            } catch (e: Exception) {
                Log.e("Post Posts Error", e.message.toString())
            }
        }
    }

    fun postUsers() {
        viewModelScope.launch {
            try {
                profileRepository.postUsers(
                    UserSavedRequest("Tnalxmsk", "MALE", 19990502, false,
                    listOf("대면"),"컴퓨터공학과", "코딩")
                ).collectLatest {
                    _defaultResult.value = it
                }

            } catch (e: Exception) {
                Log.e("Post Users Error", e.message.toString())
            }
        }
    }

    fun getPosts(categoryId: Long) {
        viewModelScope.launch {
            try {
                repository.getPosts(categoryId).collectLatest {
                    _postList.value = it
                }
            } catch (e: Exception) {
                Log.e("Get Posts Error", e.message.toString())
            }
        }
    }
}

