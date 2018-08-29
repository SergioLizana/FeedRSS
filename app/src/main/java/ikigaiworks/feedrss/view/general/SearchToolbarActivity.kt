package ikigaiworks.feedrss.view.general

import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import ikigaiworks.feedrss.R
import kotlinx.android.synthetic.main.activity_main.*

abstract open class SearchToolbarActivity : BaseActivity(), SearchView.OnQueryTextListener {


    fun setSupportActionBarToolbar(){
        setSupportActionBar(search_toolbar)
    }

    abstract fun onTitleSearch(title: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu)
        val mSearch = menu?.findItem(R.id.action_search)
        val mSearchView = mSearch?.getActionView() as SearchView
        mSearchView.queryHint = getString(R.string.search_hint)
        mSearchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextChange(p0: String?): Boolean {
       return true
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        p0?.let { onTitleSearch(it) }
        return true
    }
}