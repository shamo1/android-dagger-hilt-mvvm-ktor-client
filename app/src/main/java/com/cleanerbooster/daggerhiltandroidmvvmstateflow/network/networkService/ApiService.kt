package com.cleanerbooster.daggerhiltandroidmvvmstateflow.network.networkService

import android.net.Uri
import com.cleanerbooster.daggerhiltandroidmvvmstateflow.network.respose.PostResponseItem
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import javax.inject.Inject

class ApiService @Inject constructor(){

    val client = HttpClient(Android){
        install(DefaultRequest){
            headers.append("Content-type","application/json")
        }

        install(JsonFeature){
            serializer = GsonSerializer()
        }

        engine {
            connectTimeout = 100_000
            socketTimeout = 100_000
        }

    }

    suspend fun getPost() : ArrayList<PostResponseItem>{
        return client.get{
             url("https://jsonplaceholder.typicode.com/posts")

         }
    }
}