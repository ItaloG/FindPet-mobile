package com.example.app_findpet.classes

import com.google.gson.annotations.SerializedName

class InstituicaoServicos(
    var id: Int,
    @SerializedName("service_id")
    var servico: String
)