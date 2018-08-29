package ikigaiworks.feedrss.utils

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Naufal on 03/02/2018.
 */

abstract class BaseViewHolder<T, L : BaseRecyclerListener>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(item: T, listener: L?)
}