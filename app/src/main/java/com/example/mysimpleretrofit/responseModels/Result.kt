package com.example.mysimpleretrofit.responseModels

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("medicineId") var medicineId: String? = null,
    @SerializedName("medicineName") var medicineName: String? = null,
    @SerializedName("medicinePackaging") var medicinePackaging: String? = null,
    @SerializedName("hasBarcode") var hasBarcode: String? = null,
    @SerializedName("therapeutic") var therapeutic: String? = null,
    @SerializedName("subtherapeutic") var subtherapeutic: String? = null,
    @SerializedName("medicineBaseName") var medicineBaseName: String? = null,
    @SerializedName("medicineNameNoSpace") var medicineNameNoSpace: String? = null,
    @SerializedName("medicineNameDetailed") var medicineNameDetailed: String? = null,
    @SerializedName("itemType") var itemType: String? = null,
    @SerializedName("src") var src: String? = null,
    @SerializedName("qualifier") var qualifier: String? = null,
    @SerializedName("manufacturerName") var manufacturerName: String? = null,
    @SerializedName("verified") var verified: Boolean? = null,
    @SerializedName("isLoose") var isLoose: Boolean? = null,
    @SerializedName("divisor") var divisor: Int? = null,
    @SerializedName("images") var images: String? = null,
    @SerializedName("manufacturer") var manufacturer: Manufacturer? = Manufacturer(),
    @SerializedName("generic") var generic: Generic? = Generic(),
    @SerializedName("category") var category: Category? = Category(),
    @SerializedName("imageUrls") var imageUrls: String? = null,
    @SerializedName("ucode") var ucode: String? = null,
    @SerializedName("mappingId") var mappingId: String? = null,
    @SerializedName("stage") var stage: String? = null,
    @SerializedName("mdmid") var mdmid: String? = null
)

data class Category(
    @SerializedName("categoryId") var categoryId: String? = null,
    @SerializedName("categoryName") var categoryName: String? = null,
    @SerializedName("categoryDescription") var categoryDescription: String? = null,
    @SerializedName("categoryShortName") var categoryShortName: String? = null
)

data class Generic(
    @SerializedName("genericId") var genericId: String? = null,
    @SerializedName("genericName") var genericName: String? = null,
    @SerializedName("genericDosage") var genericDosage: String? = null,
    @SerializedName("genericDescription") var genericDescription: String? = null,
    @SerializedName("genericType") var genericType: String? = null,
    @SerializedName("isH1") var isH1: String? = null,
    @SerializedName("isTB") var isTB: String? = null,
    @SerializedName("isBanned") var isBanned: String? = null,
    @SerializedName("bannedOn") var bannedOn: String? = null,
    @SerializedName("genericDosageNoSpace") var genericDosageNoSpace: String? = null
)

data class Manufacturer(
    @SerializedName("manufacturerId") var manufacturerId: String? = null,
    @SerializedName("manufacturerName") var manufacturerName: String? = null,
    @SerializedName("manufacturerEmail") var manufacturerEmail: String? = null,
    @SerializedName("manufacturerWebsite") var manufacturerWebsite: String? = null,
    @SerializedName("isGlobal") var isGlobal: String? = null,
    @SerializedName("isActive") var isActive: Boolean? = null
)