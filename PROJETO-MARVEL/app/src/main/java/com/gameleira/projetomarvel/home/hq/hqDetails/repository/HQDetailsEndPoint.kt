package com.gameleira.projetomarvel.home.hq.hqDetails.repository

import com.gameleira.projetomarvel.network.Network
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HQDetailsEndPoint {

    @GET("comics/{comicId}")
    suspend fun get(
        @Path("comicId") comicId: Int,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?,
    ): ResponseModel<>

    companion object {
        val endpoint: ComicDetailsEndpoint by lazy {
            Networt.getRetrofitInstance().create(HQDetailsEndPoint::class.java)
        }
    }
}