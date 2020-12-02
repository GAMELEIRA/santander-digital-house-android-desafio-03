package com.gameleira.projetomarvel.network

import com.gameleira.projetomarvel.extensions.ExtensionMarvelApi
import com.gameleira.projetomarvel.extensions.ExtensionMarvelApi.Companion.getTimeStamp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        private const val BASE_URL = "https://gateway.marvel.com/v1/public/";
        const val PUBLIC_KEY_MARVEL = "6eb7e8896ec5850c52515a8a23ee97f0";
        private const val PRIVATE_KEY_MARVEL = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";

        fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getHash(): String? {
            return ExtensionMarvelApi.md5(getTimeStamp() + PRIVATE_KEY_MARVEL + PUBLIC_KEY_MARVEL);
        }
    }
}