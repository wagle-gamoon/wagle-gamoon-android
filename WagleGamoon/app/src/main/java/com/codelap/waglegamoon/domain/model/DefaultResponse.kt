package com.codelap.waglegamoon.domain.model

data class DefaultResponse(
    val status: String = "",
    val data: Long = 0,
    val message: String = "",
    val success: Boolean = false
)
