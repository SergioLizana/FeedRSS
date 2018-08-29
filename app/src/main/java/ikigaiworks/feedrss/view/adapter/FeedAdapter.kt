package ikigaiworks.feedrss.view.adapter

import android.content.Context
import android.view.ViewGroup
import ikigaiworks.feedrss.R
import ikigaiworks.feedrss.model.ItemsItem
import ikigaiworks.feedrss.utils.GenericRecyclerViewAdapter
import ikigaiworks.feedrss.utils.OnRecyclerObjectClickListener
import ikigaiworks.feedrss.view.viewholder.FeedViewHolder


class FeedAdapter(_context: Context) : GenericRecyclerViewAdapter<ItemsItem, OnRecyclerObjectClickListener<ItemsItem>, FeedViewHolder>(_context) {

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FeedViewHolder {
            return FeedViewHolder(inflate(R.layout.row_feed_list, parent = viewGroup))
        }
}
