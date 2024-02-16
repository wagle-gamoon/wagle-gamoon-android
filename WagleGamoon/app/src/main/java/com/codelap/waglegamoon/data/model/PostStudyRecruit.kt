package com.codelap.waglegamoon.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostStudyRecruit(
    val postId: Long,
    val recruitState: String,
    val studyFiled: String,
    val location: String,
    val postTitle: String,
    val date: String,
    val nickname: String
) : Parcelable
