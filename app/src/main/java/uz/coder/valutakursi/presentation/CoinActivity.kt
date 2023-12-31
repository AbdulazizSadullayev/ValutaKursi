package uz.coder.valutakursi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import uz.coder.valutakursi.databinding.ActivityCoinBinding
import uz.coder.valutakursi.domain.CoinInfo
import uz.coder.valutakursi.presentation.vm.CoinViewModel

class CoinActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var coinViewModel: CoinViewModel
    private lateinit var adapter: CoinAdapter
    private lateinit var binding: ActivityCoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        coinViewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        adapter = CoinAdapter()

        adapter.onclick = object : CoinAdapter.OnClickItem {
            override fun onCoinClick(coinInfo: CoinInfo) {
                val newIntent = CoinActivityDetail.newIntent(this@CoinActivity, coinInfo.fromSymbol)
                startActivity(newIntent)
            }

        }
        coinViewModel.coinInfoList.observe(this) {
           adapter.submitList(it)
        }
        binding.rec.itemAnimator = null
        binding.rec.adapter = adapter

    }


}