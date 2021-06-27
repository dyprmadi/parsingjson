package com.yana.permadi.dendi.dyprmdiparsingjson.model

import android.graphics.pdf.PdfRenderer
import com.google.gson.annotations.SerializedName

data class ResponUser(
    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("per_page")
    val per_page: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("total_pages")
    val total_pages: Int? = null,

    @field:SerializedName("data")
    val data: List<DataItem>? = null

)
