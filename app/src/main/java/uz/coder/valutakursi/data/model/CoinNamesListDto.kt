package uz.coder.valutakursi.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import uz.coder.valutakursi.data.model.CoinNameContainerDto

data class CoinNamesListDto (
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerDto>? = null
)