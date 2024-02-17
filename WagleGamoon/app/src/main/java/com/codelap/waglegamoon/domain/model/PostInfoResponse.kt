package com.codelap.waglegamoon.domain.model

data class PostInfoResponse(
    val status: String = "",
    val data: PostResponseDto?,
    val message: String = "",
    val success: Boolean = false
)
