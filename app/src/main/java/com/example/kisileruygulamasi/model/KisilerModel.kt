package com.example.kisileruygulamasi.model

import java.io.Serializable

data class KisilerModel(var kisi_id: Int, var kisi_ad: String, var kisi_tel: String) :
    Serializable {
}