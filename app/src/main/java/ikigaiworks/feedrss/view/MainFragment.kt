package ikigaiworks.feedrss.view

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import ikigaiworks.feedrss.api.observer.ApiObserver
import ikigaiworks.feedrss.model.FeedResponse
import ikigaiworks.feedrss.viewmodel.FeedViewModel


class MainFragment : Fragment(), LifecycleOwner {

    private var viewModel: FeedViewModel? = ViewModelProviders.of(this).get(FeedViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun observeViewModel() {
        viewModel?.searchFeedRss()?.observe(this, ApiObserver(object : ApiObserver.ChangeListener<FeedResponse> {
            override fun onSuccess(dataWrapper: FeedResponse?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onException(exception: Exception?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }))
    }


}

