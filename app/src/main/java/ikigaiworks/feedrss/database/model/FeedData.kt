package ikigaiworks.feedrss.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "feedData")
data class FeedData(@PrimaryKey(autoGenerate = true) var id: Long?,
                    @ColumnInfo(name = "title") var title: String?,
                    @ColumnInfo(name = "thumbnail") var thumbnail: String?,
                    @ColumnInfo(name = "detail") var detail: String?,
                    @ColumnInfo(name = "link") var link: String?,
                    @ColumnInfo(name = "author") var author: String?,
                    @ColumnInfo(name = "pubDate") var pubDate: String?


){
    constructor():this(null,"","","","","", "")
}