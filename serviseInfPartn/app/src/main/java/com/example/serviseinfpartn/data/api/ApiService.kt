package com.example.serviseinfpartn.data.api

import com.example.serviseinfpartn.data.models.ResponseApi
import com.example.serviseinfpartn.data.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAll(): Response<ResponseApi>

}

