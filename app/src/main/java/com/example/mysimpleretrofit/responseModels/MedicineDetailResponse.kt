package com.example.mysimpleretrofit.responseModels

import com.google.gson.annotations.SerializedName

data class MedicineDetailResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("result") var result: Result? = Result()
)
