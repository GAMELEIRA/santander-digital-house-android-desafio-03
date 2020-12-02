package com.gameleira.projetomarvel.home.hq.repository

import com.gameleira.projetomarvel.data.Res
import com.gameleira.projetomarvel.home.hq.model.HQ
import com.gameleira.projetomarvel.network.Network
import retrofit2.http.GET
import retrofit2.http.Query

interface HQEndPoint {

    @GET("series/9906/comics")
    suspend fun get(
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?,
    ): Res<HQ>

    companion object {
        val endpoint: HQEndPoint by lazy {
            Network.getRetrofitInstance().create(HQEndPoint::class.java)
        }
    }
}