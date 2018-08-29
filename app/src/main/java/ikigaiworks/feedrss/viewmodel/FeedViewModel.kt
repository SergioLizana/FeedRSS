package ikigaiworks.feedrss.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import ikigaiworks.feedrss.api.rest.FeedInteractor
import ikigaiworks.feedrss.api.wrapper.DataWrapper
import ikigaiworks.feedrss.model.FeedResponse

class FeedViewModel(app: Application): AndroidViewModel(app) {

    fun searchFeedRss(): LiveData<DataWrapper<FeedResponse>>? {
        return FeedInteractor.createInstance().onFeedRequest()
    }

}