package ikigaiworks.feedrss.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import ikigaiworks.feedrss.api.wrapper.DataWrapper
import ikigaiworks.feedrss.model.FeedResponse

class FeedViewModel(app: Application): AndroidViewModel(app) {
    fun searchFeedRss(): MutableLiveData<DataWrapper<FeedResponse>>? {
        return null
    }

}