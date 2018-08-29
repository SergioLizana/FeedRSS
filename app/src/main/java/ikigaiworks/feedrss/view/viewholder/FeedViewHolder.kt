package ikigaiworks.feedrss.view.viewholder

import android.support.annotation.Nullable
import android.view.View
import com.bumptech.glide.Glide
import ikigaiworks.feedrss.model.ItemsItem
import ikigaiworks.feedrss.utils.BaseViewHolder
import ikigaiworks.feedrss.utils.OnRecyclerObjectClickListener
import kotlinx.android.synthetic.main.row_feed_list.view.*


class FeedViewHolder(itemView: View) : BaseViewHolder<ItemsItem, OnRecyclerObjectClickListener<ItemsItem>>(itemView) {



    override fun onBind(item: ItemsItem, @Nullable listener: OnRecyclerObjectClickListener<ItemsItem>?) {
        /**
         * add listener to your itemView you can add anyview you wish to add click listener
         */

        Glide.with(itemView.context).load(item.thumbnail).into(itemView.thumbnail)
        itemView.feed_title.text = item.title
        itemView.publish_date.text = item.pubDate

        if (listener != null) {
            itemView.setOnClickListener { listener.onItemClicked(item) }
        }
    }
}