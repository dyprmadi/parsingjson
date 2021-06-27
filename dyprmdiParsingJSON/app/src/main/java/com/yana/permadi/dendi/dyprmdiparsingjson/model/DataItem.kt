package com.yana.permadi.dendi.dyprmdiparsingjson.model

import com.google.gson.annotations.SerializedName


data class DataItem(
        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("first_name")
        val first_name: String? = null,

        @field:SerializedName("last_name")
        val last_name: String? = null,

        @field:SerializedName("avatar")
        val avatar: String? = null

)