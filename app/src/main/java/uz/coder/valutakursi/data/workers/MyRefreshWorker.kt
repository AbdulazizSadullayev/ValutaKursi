package uz.example.cryptovalyuta.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters

import kotlinx.coroutines.delay
import uz.coder.valutakursi.data.database.AppDatabase
import uz.coder.valutakursi.data.mapper.CoinMapper
import uz.coder.valutakursi.data.network.ApiClient
import uz.coder.valutakursi.data.network.ApiService

class MyRefreshWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {
    private val coinInfoDao = AppDatabase.getInstens(context).coinPriceInfoDao()
    private val mapper = CoinMapper()
    private val apiService = ApiClient.getRetrofit().create(ApiService::class.java)

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fSyms = mapper.mapListDbModelEntity(topCoins)
                val jsonContainer = apiService.getFullInformation( fsym = fSyms)
                val coinInfoDtoList = mapper.maptoContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.coinInfoDtoToDbModel(it) }
                coinInfoDao.inserPriceList(dbModelList)
            } catch (e: Exception) {
            }
            delay(10000)
        }
    }



    companion object {
        const val NAME = "MyRefreshWorker"
        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<MyRefreshWorker>().build()
        }
    }


}