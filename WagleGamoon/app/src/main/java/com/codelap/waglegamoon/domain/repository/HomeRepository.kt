package com.codelap.waglegamoon.domain.repository

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.PostListResponse
import com.codelap.waglegamoon.domain.model.PostSaveDto
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun postPosts(userId: Long, postSaveDto: PostSaveDto): Flow<DefaultResponse>
    suspend fun getPosts(categoryId: Long): Flow<PostListResponse>
}