package hf.dra.anotherjisho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hf.dra.anotherjisho.fragments.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val fragment = SearchFragment()
        showFragment(fragment, SearchFragment.TAG)
    }

    fun showFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.setCustomAnimations(
            android.R.anim.fade_in,
            android.R.anim.fade_out,
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )

        transaction.replace(R.id.main_container, fragment, tag)

        transaction.addToBackStack(tag)

        transaction.commitAllowingStateLoss()
    }
}