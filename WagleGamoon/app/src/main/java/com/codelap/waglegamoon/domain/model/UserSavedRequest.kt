package com.codelap.waglegamoon.domain.model

data class UserSavedRequest(
    val userNickname: String,
    val userGender: String,
    val year: Int,
    val userGraduate: Boolean,
    val userKeywords: List<String>,
    val userDepartment: String,
    val preferInterests: String
)
