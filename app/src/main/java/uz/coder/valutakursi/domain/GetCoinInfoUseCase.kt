package uz.coder.valutakursi.domain

import uz.coder.valutakursi.domain.CoinRepository

class GetCoinInfoUseCase(private val repository: CoinRepository) {
    operator fun invoke(fromSymbol: String) = repository.getCoin(fromSymbol)
}