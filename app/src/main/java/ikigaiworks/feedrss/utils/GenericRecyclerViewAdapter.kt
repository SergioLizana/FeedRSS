package ikigaiworks.feedrss.utils

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*


abstract class GenericRecyclerViewAdapter<T, L : BaseRecyclerListener, VH : BaseViewHolder<T, L>>(_context: Context) : RecyclerView.Adapter<VH>() {

    private val items: MutableList<T>?
    private var listener: L? = null
    private val layoutInflater: LayoutInflater

    val isAdapterEmpty: Boolean
        get() = itemCount == 0

    init {
        layoutInflater = LayoutInflater.from(_context)
        items = ArrayList()
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items!![position]
        holder.onBind(item, listener)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun setItems(items: List<T>?) {
        if (items == null) throw IllegalArgumentException("Cannot set `null` to Recyclerview")
        this.items!!.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun getItems(): List<T>? {
        return this.items
    }

    fun item(position: Int): T {
        return this.items!![position]
    }

    fun add(item: T?) {
        if (item == null) throw IllegalArgumentException("Cannot add `null` to Recyclerview")
        this.items!!.add(item)
        notifyItemInserted(this.items.size - 1)
    }

    fun addAll(items: List<T>?) {
        if (items == null) throw IllegalArgumentException("Cannot add `null` to Recyclerview")
        this.items!!.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    fun clear() {
        this.items!!.clear()
        notifyDataSetChanged()
    }

    fun remove(item: T) {
        val position = this.items!!.indexOf(item)
        if (position > -1) {
            this.items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }

    fun setListener(listener: L) {
        this.listener = listener
    }

    @JvmOverloads
    protected fun inflate(@LayoutRes layout: Int, parent: ViewGroup?, attachToRoot: Boolean = false): View {
        return layoutInflater.inflate(layout, parent, attachToRoot)
    }
}