package com.codelap.waglegamoon.domain.model

data class PostResponseDto(
    val postId: Long,
    val title: String,
    val userNickname: String,
    val createAt: String
)