package com.unsoed.responsi1mobileh1d023014.data.api

import com.unsoed.responsi1mobileh1d023014.data.model.Team
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("X-Auth-Token: 0114ecdce5f943e49affca21d26aab2e")
    @GET("teams/{id}")
    suspend fun getTeam(@Path("id") id: Int): Team
}
