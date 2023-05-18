package com.example.hiltnewsetup.model

import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("body")
    val body: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
)