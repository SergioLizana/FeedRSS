package ikigaiworks.feedrss.api.rest

import android.arch.lifecycle.LiveData

import ikigaiworks.feedrss.api.requesthandler.GenericRequestHandler
import ikigaiworks.feedrss.api.wrapper.DataWrapper
import ikigaiworks.feedrss.model.FeedResponse
import ikigaiworks.feedrss.utils.Constants
import ikigaiworks.recipepuppyapi.api.rest.FeedService
import retrofit2.Call
import retrofit2.Response

class FeedInteractor : GenericRequestHandler<FeedResponse>() {

    fun onFeedRequest(): LiveData<DataWrapper<FeedResponse>> {
        return doRequest()
    }

    override fun makeRequest(): Call<FeedResponse> {
        return FeedService.getClient().getRssFeed(Constants.FEED_ELMUNDO_URL)
    }

    companion object {
        fun createInstance(): FeedInteractor {
            return FeedInteractor()
        }
    }
}