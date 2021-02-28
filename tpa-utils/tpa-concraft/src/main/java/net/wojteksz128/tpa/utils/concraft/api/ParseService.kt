package net.wojteksz128.tpa.utils.concraft.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ParseService {
    @POST("/parse")
    fun parse(@Body param: DagParam): Call<DagParam>
}
