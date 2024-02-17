package com.codelap.waglegamoon.data.datasource.post

import android.util.Log
import com.codelap.waglegamoon.data.remote.GamoonService
import com.codelap.waglegamoon.domain.model.PostListResponse
import com.codelap.waglegamoon.domain.model.PostSaveDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val gamoonService: GamoonService
) {

    suspend fun postPosts(userId: Long, postSaveDto: PostSaveDto) = flow {
        val response = gamoonService.postPosts(userId, postSaveDto)
        emit(response)
    }

    suspend fun getPosts(categoryId: Long): Flow<PostListResponse> = flow {
        val response = gamoonService.getPosts(categoryId)
        emit(response)
    }.catch {
        Log.e("Get Posts Fauilure", it.message.toString())
    }
}