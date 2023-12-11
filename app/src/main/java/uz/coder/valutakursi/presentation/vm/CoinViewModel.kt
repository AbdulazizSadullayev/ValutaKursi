package uz.coder.valutakursi.presentation.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uz.coder.valutakursi.data.CoinInfoRepositoryImpl
import uz.coder.valutakursi.domain.GetCoinInfoListUseCase
import uz.coder.valutakursi.domain.GetCoinInfoUseCase
import uz.coder.valutakursi.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {
    val repository = CoinInfoRepositoryImpl(application)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSmy: String) = getCoinInfoUseCase(fSmy)

    init {
        loadDataUseCase()
    }


}