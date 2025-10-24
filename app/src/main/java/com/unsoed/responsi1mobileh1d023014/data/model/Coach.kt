package com.unsoed.responsi1mobileh1d023014.data.model

import com.google.gson.annotations.SerializedName

data class Coach(
    val id: Int?,
    val name: String?,
    val nationality: String?,


    @SerializedName("dateOfBirth")
    val dateOfBirth: String?
)

