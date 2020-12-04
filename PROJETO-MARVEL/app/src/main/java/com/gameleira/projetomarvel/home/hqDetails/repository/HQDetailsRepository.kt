package com.gameleira.projetomarvel.home.hqDetails.repository

import com.gameleira.projetomarvel.extensions.ExtensionMarvelApi.Companion.getTimeStamp
import com.gameleira.projetomarvel.network.Network

class HQDetailsRepository {
    private val client = HQDetailsEndPoint.endpoint

    suspend fun getHQDetails(comicId: Int) = client.get(
        comicId,
        getTimeStamp(),
        Network.getHash(),
        Network.PUBLIC_KEY_MARVEL,
    )
}