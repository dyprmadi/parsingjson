package com.yana.permadi.dendi.dyprmdiparsingjson.network

import com.yana.permadi.dendi.dyprmdiparsingjson.model.ResponUser
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //Menampilkan user dengan query
    @GET("api/user")
    fun getListUsers(@Query("page")page: String): retrofit2.Call<ResponUser>
}