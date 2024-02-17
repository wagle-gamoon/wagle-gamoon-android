package com.codelap.waglegamoon.data.datasource.user

import android.content.ContentValues.TAG
import android.util.Log
import com.codelap.waglegamoon.data.remote.GamoonService
import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserDataSource @Inject constructor(
    private val gamoonService: GamoonService
) {
    fun postUsers(userSavedRequest: UserSavedRequest): Flow<DefaultResponse> = flow {
        val response = gamoonService.postUsers(userSavedRequest)
        emit(response)
    }.catch {
        Log.e(TAG, "Post Users Failure: ${it.message.toString()}")
    }
}