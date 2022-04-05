package com.example.mysimpleretrofit.responseModels

import com.google.gson.annotations.SerializedName

data class SecondApiResponse(

    @SerializedName("id") var id: String? = null,
    @SerializedName("gst") var gst: Double? = null,
    @SerializedName("div") var div: Int? = null,
    @SerializedName("hsn") var hsn: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("pack") var pack: String? = null,
    @SerializedName("cid") var cid: String? = null,
    @SerializedName("gid") var gid: String? = null,
    @SerializedName("mfid") var mfid: String? = null,
    @SerializedName("mname") var mname: String? = null,
    @SerializedName("mdmid") var mdmid: String? = null,
    @SerializedName("subgroupid") var subgroupid: String? = null,
    @SerializedName("gname") var gname: String? = null,
    @SerializedName("gtype") var gtype: String? = null,
    @SerializedName("gisban") var gisban: Boolean? = null,
    @SerializedName("gh1") var gh1: Boolean? = null

)