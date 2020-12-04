package com.gameleira.projetomarvel.home.hqDetails.repository

import com.gameleira.projetomarvel.data.Resp
import com.gameleira.projetomarvel.home.hq.model.HQ
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
    ): Resp<HQ>

    companion object {
        val endpoint: HQDetailsEndPoint by lazy {
            Network.getRetrofitInstance().create(HQDetailsEndPoint::class.java)
        }
    }
}