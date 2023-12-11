package uz.coder.valutakursi.presentation

import androidx.recyclerview.widget.DiffUtil
import uz.coder.valutakursi.domain.CoinInfo

class CoinDiffCallback():DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}