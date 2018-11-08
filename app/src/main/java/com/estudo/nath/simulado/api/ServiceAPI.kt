package com.estudo.nath.simulado.api

import com.estudo.nath.simulado.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceAPI{
    @GET("/api/people/{codigousuario}/")
    fun buscarUsuario(@Path("codigousuario")codigousuario:String):Call<Usuario>
}

