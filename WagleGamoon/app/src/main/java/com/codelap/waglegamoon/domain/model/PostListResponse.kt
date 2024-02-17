package com.codelap.waglegamoon.domain.model

data class PostListResponse(
    val status: String = "",
    val data: List<PostResponseDto>,
    val message: String = "",
    val success: Boolean = false
)