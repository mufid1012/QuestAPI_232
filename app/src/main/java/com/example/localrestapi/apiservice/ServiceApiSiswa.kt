package com.example.localrestapi.service

import com.example.localrestapi.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ServiceApiSiswa{
    @GET("bacateman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa):retrofit2.Response<Void>

    // GET satu data teman (pakai ?id=)
    @GET("baca1teman.php")
    suspend fun getSatuSiswa(
        @Query("id") id: Int
    ): DataSiswa

    // UPDATE data teman
    @PUT("editTM.php")
    suspend fun editSatuSiswa(
        @Query("id") id: Int,
        @Body dataSiswa: DataSiswa
    ): Response<Void>

    // DELETE data teman
    @DELETE("deleteTM.php")
    suspend fun hapusSatuSiswa(
        @Query("id") id: Int
    ): Response<Void>

}