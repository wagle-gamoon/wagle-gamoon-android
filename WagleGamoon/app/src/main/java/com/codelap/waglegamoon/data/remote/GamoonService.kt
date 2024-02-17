package com.codelap.waglegamoon.data.remote

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface GamoonService {

    @POST("/users")
    suspend fun postUsers(@Body usersSavedRequest: UserSavedRequest): DefaultResponse
}