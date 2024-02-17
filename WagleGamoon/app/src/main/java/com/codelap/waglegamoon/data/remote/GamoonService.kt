package com.codelap.waglegamoon.data.remote

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.PostSaveDto
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GamoonService {

    @POST("/posts/{userId}")
    suspend fun postPosts(
        @Path("userId") userId: Long,
        @Body postSaveDto: PostSaveDto
    ): DefaultResponse

    @POST("/users")
    suspend fun postUsers(@Body usersSavedRequest: UserSavedRequest): DefaultResponse
}