package com.utad.mvvmtareas.data.network

import com.utad.mvvmtareas.data.network.model.HomeWorkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface SchoolService {
    // 1 hago el get del endpoint
    @GET("homeWork/{nombreColegio}")
    // 2 creo la funcion que devuelva la clase original (es el nombre de la clase que colocamos al crear el Json)
    suspend fun getAllTareas(@Header("Authorization") userName: String, @Path("nombreColegio") nombre: String): Response<List<HomeWorkResponse>>
}