package com.codelap.waglegamoon.domain.repository

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.PostSaveDto
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun postPosts(userId: Long, postSaveDto: PostSaveDto): Flow<DefaultResponse>
}