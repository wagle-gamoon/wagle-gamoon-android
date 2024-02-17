package com.codelap.waglegamoon.data.datasource.post

import com.codelap.waglegamoon.data.remote.GamoonService
import com.codelap.waglegamoon.domain.model.PostSaveDto
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val gamoonService: GamoonService
) {

    fun postPosts(userId: Long, postSaveDto: PostSaveDto) = flow {
        val response = gamoonService.postPosts(userId, postSaveDto)
        emit(response)
    }
}