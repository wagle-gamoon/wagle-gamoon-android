package com.codelap.waglegamoon.domain.model

data class PostSaveDto(
    val categorySort: String,
    val title: String,
    val place: String,
    val content: String,
    val totalCount: Int,
    val currentCount: Int
)
