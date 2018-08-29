package ikigaiworks.feedrss.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import ikigaiworks.feedrss.database.dao.FeedDao
import ikigaiworks.feedrss.database.model.FeedData

@Database(entities = arrayOf(FeedData::class), version = 1)
abstract class FeedDataBase : RoomDatabase() {

    abstract fun feedDao(): FeedDao

    companion object {
        private var INSTANCE: FeedDataBase? = null

        fun getInstance(context: Context): FeedDataBase? {
            if (INSTANCE == null) {
                synchronized(FeedDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            FeedDataBase::class.java, "feed.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}