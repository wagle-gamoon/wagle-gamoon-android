package com.codelap.waglegamoon.data.remote

import com.codelap.waglegamoon.domain.model.DefaultResponse
import com.codelap.waglegamoon.domain.model.PostInfoResponse
import com.codelap.waglegamoon.domain.model.PostListResponse
import com.codelap.waglegamoon.domain.model.PostSaveDto
import com.codelap.waglegamoon.domain.model.UserSavedRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GamoonService {

    @POST("/posts/{userId}")
    suspend fun postPosts(
        @Path("userId") userId: Long,
        @Body postSaveDto: PostSaveDto
    ): DefaultResponse

    @GET("posts/{postId}")
    suspend fun getPostsInfo(@Path("postId") postId: Long): PostInfoResponse

    @GET("/posts")
    suspend fun getPosts(@Query("categoryId") categoryId: Long): PostListResponse

    @POST("/users")
    suspend fun postUsers(@Body usersSavedRequest: UserSavedRequest): DefaultResponse
}