package ikigaiworks.feedrss.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.util.Log
import ikigaiworks.feedrss.api.rest.FeedInteractor
import ikigaiworks.feedrss.api.wrapper.DataWrapper
import ikigaiworks.feedrss.database.FeedDataBase
import ikigaiworks.feedrss.database.model.FeedData
import ikigaiworks.feedrss.model.FeedResponse
import ikigaiworks.feedrss.application.MyApplication



class FeedViewModel(app: Application): AndroidViewModel(app) {

    fun searchFeedRss(): LiveData<DataWrapper<FeedResponse>>? {
        return FeedInteractor.createInstance().onFeedRequest()
    }

    fun searchFeedRssDatabase(): LiveData<List<FeedData>>? {
        return FeedDataBase.getInstance(getApplication())?.feedDao()?.getAll()
    }

    fun saveInDataBase(title: String?, thumbnail: String?, detail: String?, link: String?, author: String?, pubDate: String?){

        MyApplication.runInBackground(Runnable {
            Log.d("Saving Data", "Saving data in database: title: $title")
            val feedData = FeedData(null,title,thumbnail,detail,link,author,pubDate)
            FeedDataBase.getInstance(getApplication())?.feedDao()?.insert(feedData)
        })

    }

    fun destroyData(){
        FeedDataBase.destroyInstance()
    }

}