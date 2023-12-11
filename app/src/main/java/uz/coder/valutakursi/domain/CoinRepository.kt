package uz.coder.valutakursi.domain

import androidx.lifecycle.LiveData
import uz.coder.valutakursi.domain.CoinInfo

interface CoinRepository {
    fun getCoinInfoList():LiveData<List<CoinInfo>>
    fun getCoin(fromSymbol: String):LiveData<CoinInfo>

     fun loadData()

}