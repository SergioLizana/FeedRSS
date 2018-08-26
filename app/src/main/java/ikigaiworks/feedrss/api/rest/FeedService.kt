package ikigaiworks.recipepuppyapi.api.rest

import ikigaiworks.feedrss.api.rest.client.FeedRSSApiClient
import ikigaiworks.feedrss.utils.Constants.Companion.FEED_URL_API
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class FeedService {
    companion object {
        fun getClient(): FeedRSSApiClient{
            val retrofit = Retrofit.Builder()
                    .baseUrl(FEED_URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(FeedRSSApiClient::class.java)
        }
    }
}