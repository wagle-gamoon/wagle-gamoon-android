package com.codelap.waglegamoon.data.datasource.user

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import com.codelap.waglegamoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {
    override fun postUsers(userSavedRequest: UserSavedRequest): Flow<DefaultResponse> = dataSource.postUsers(userSavedRequest)
}