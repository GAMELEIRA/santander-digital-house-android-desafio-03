package com.gameleira.projetomarvel.home.hq.repository

import com.gameleira.projetomarvel.extensions.ExtensionMarvelApi.Companion.getTimeStamp
import com.gameleira.projetomarvel.network.Network.Companion.PUBLIC_KEY_MARVEL
import com.gameleira.projetomarvel.network.Network.Companion.getHash

class HQRepository {
    private val client = HQEndPoint.endpoint

    suspend fun getHQs() = client.get(getTimeStamp(), getHash(), PUBLIC_KEY_MARVEL)
}