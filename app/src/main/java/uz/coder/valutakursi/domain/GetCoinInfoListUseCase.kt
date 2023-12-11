package uz.coder.valutakursi.domain

import uz.coder.valutakursi.domain.CoinRepository

class GetCoinInfoListUseCase(private val repository: CoinRepository) {

    operator fun invoke()=repository.getCoinInfoList()
}