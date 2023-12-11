package uz.coder.valutakursi.domain

import uz.coder.valutakursi.domain.CoinRepository

class LoadDataUseCase(private val repository: CoinRepository) {
 operator fun invoke() = repository.loadData()
}