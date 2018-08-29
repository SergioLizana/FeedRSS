package ikigaiworks.feedrss.view

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ikigaiworks.feedrss.R
import ikigaiworks.feedrss.api.observer.ApiObserver
import ikigaiworks.feedrss.database.model.FeedData
import ikigaiworks.feedrss.model.FeedResponse
import ikigaiworks.feedrss.model.ItemsItem
import ikigaiworks.feedrss.utils.OnRecyclerObjectClickListener
import ikigaiworks.feedrss.view.adapter.FeedAdapter
import ikigaiworks.feedrss.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.error_list.*
import kotlinx.android.synthetic.main.fragment_feed_list.*


class MainFragment : Fragment(), LifecycleOwner , OnRecyclerObjectClickListener<ItemsItem> {
    override fun onItemClicked(item: ItemsItem) {

    }

    private lateinit var viewModel: FeedViewModel
    private var adapter: FeedAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        context?.let { FeedAdapter(it) }
        observeViewModel()
    }

    private fun observeViewModel() {
        val hasInternet = false
        if(!hasInternet) {
            viewModel?.searchFeedRssDatabase()?.observe(this, Observer<List<FeedData>> {
                Log.d("datos", "wiiii ")
            })
        }else{
            viewModel?.searchFeedRss()?.observe(this, ApiObserver(object : ApiObserver.ChangeListener<FeedResponse> {
                override fun onSuccess(dataWrapper: FeedResponse?) {
                    loadData(dataWrapper)
                    saveInDataBase(dataWrapper)
                }

                override fun onException(exception: Exception?) {
                    loadError(exception?.message)
                }
            }))
        }
    }

    private fun saveInDataBase(dataWrapper: FeedResponse?) {
        viewModel.destroyData()
        for (item in dataWrapper?.items!!){
            viewModel.saveInDataBase(item.title,item.thumbnail,item.description,item.link,item.author,item.pubDate)
        }


    }

    private fun loadData(response: FeedResponse?){
        showErrorView(false)
        adapter?.setListener(this)
        feed_list.layoutManager = context?.let { LinearLayoutManager(it) }
        feed_list.adapter = adapter
        adapter?.setItems(response?.items)
    }

    private fun loadError(errorMsg: String?){
        showErrorView(true)
        error_msg.text = errorMsg
    }

    private fun showErrorView(condition: Boolean){
        if(condition){
            error_view.visibility = View.VISIBLE
            feed_list.visibility = View.GONE
        }else{
            error_view.visibility = View.GONE
            feed_list.visibility = View.VISIBLE
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ListFragment.
         */
        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

}

