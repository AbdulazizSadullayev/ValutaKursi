package uz.coder.valutakursi.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.coder.valutakursi.data.database.CoinInfoDbModel

@Dao
interface CoinPriceInfoDao {
    @Query("SELECT * FROM full_price_list ORDER by lastupdate DESC")
    fun getPriceList():LiveData<List<CoinInfoDbModel>>

    @Query("Select  * from full_price_list where fromSymbol = :fsym Limit 1")
    fun getPriceCoinInfoAbout(fsym:String):LiveData<CoinInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserPriceList(priceList:List<CoinInfoDbModel>)

}