package com.codelap.waglegamoon.data.datasource.post

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.PostSaveDto
import com.codelap.waglegamoon.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource
) : HomeRepository {
    override fun postPosts(userId: Long, postSaveDto: PostSaveDto): Flow<DefaultResponse> = dataSource.postPosts(userId, postSaveDto)
}