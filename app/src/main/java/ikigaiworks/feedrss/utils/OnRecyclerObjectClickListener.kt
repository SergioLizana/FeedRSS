package ikigaiworks.feedrss.utils

interface OnRecyclerObjectClickListener<T> : BaseRecyclerListener {
    fun onItemClicked(item: T)
}