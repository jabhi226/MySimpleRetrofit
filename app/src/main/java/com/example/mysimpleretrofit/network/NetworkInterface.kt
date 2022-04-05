package com.example.mysimpleretrofit.network

import com.example.mysimpleretrofit.responseModels.MedicineDetailResponse
import com.example.mysimpleretrofit.responseModels.SecondApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NetworkInterface {

    // first api with dynamic url
    @GET
    fun apiWithFirstUrl(
        @Url url: String,
        @Query("id") medicineId: String
    ): Call<MedicineDetailResponse>

    // second api with default url
    @GET("/v1/aa0d426e-c897-4646-866f-9f666023f4a4")
    fun apiWithSecondUrl(): Call<List<SecondApiResponse>>
}