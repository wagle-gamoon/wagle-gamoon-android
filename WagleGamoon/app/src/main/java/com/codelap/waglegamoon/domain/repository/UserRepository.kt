package com.codelap.waglegamoon.domain.repository

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun postUsers(userSavedRequest: UserSavedRequest): Flow<DefaultResponse>
}