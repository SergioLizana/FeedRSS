package ikigaiworks.feedrss.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import ikigaiworks.feedrss.database.model.FeedData

@Dao
interface FeedDao {

    @Query("SELECT * from feedData")
    fun getAll(): LiveData<List<FeedData>>

    @Insert(onConflict = REPLACE)
    fun insert(feedData: FeedData)

    @Query("DELETE from feedData")
    fun deleteAll()
}