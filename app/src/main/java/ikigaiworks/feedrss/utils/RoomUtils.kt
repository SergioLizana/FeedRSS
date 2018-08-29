package ikigaiworks.feedrss.utils

import ikigaiworks.feedrss.database.model.FeedData
import ikigaiworks.feedrss.model.FeedResponse

class RoomUtils {
    companion object {
            fun parseDataBaseList(list: List<FeedData>): FeedResponse{
                val feedResponse = FeedResponse()
                return feedResponse
            }
    }
}