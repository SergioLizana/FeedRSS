package ikigaiworks.feedrss.view.general

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu

open class BaseActivity :  AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    fun transactionSubModule(fragment: Fragment, backStack: Boolean, fragmentContainer: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(fragmentContainer, fragment, fragment.tag)
        if (backStack) {
            transaction.addToBackStack(fragment.tag)
        }
        transaction.commit()
    }
}