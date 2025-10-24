package com.unsoed.responsi1mobileh1d023014.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val id: Int,
    val name: String,
    val position: String?,
    val nationality: String?,


    @SerializedName("dateOfBirth")
    val dateOfBirth: String?

) : Parcelable

