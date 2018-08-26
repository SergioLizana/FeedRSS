package ikigaiworks.feedrss.api.rest.client

import ikigaiworks.feedrss.model.FeedResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedRSSApiClient {
    @GET("/v1/api.json")
    fun getRssFeed(@Query("rss_url") rssUrl: String?): Call<FeedResponse>
}