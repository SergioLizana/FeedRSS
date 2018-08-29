package ikigaiworks.feedrss.view

import android.os.Bundle
import android.view.Menu
import ikigaiworks.feedrss.R
import ikigaiworks.feedrss.view.general.SearchToolbarActivity

class MainActivity : SearchToolbarActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBarToolbar()
        launchList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }


    override fun onTitleSearch(title: String) {

    }

    fun launchList() {
        val listFragment = MainFragment.newInstance()
        transactionSubModule(listFragment, false,R.id.fragment_container)
    }
}
