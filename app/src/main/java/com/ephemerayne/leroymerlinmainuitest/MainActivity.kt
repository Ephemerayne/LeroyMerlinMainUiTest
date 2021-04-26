package com.ephemerayne.leroymerlinmainuitest

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.iterator
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.ephemerayne.leroymerlinmainuitest.databinding.ActivityMainBinding
import com.ephemerayne.leroymerlinmainuitest.ui.cart.CartFragment
import com.ephemerayne.leroymerlinmainuitest.ui.home.HomeFragment
import com.ephemerayne.leroymerlinmainuitest.ui.mylist.MyListFragment
import com.ephemerayne.leroymerlinmainuitest.ui.profile.ProfileFragment
import com.ephemerayne.leroymerlinmainuitest.ui.stores.StoresFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(HomeFragment())

        ActivityMainBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }

        binding.navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> openFragment(fragment = HomeFragment())
                R.id.navigation_my_list -> openFragment(fragment = MyListFragment())
                R.id.navigation_stores -> openFragment(fragment = StoresFragment())
                R.id.navigation_profile -> openFragment(fragment = ProfileFragment())
                R.id.navigation_cart -> openFragment(fragment = CartFragment())
            }
            updateNavigationBarState(item.itemId)
            true
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()
    }

    private fun updateNavigationBarState(actionId: Int) {
        val menu: Menu = binding.navView.menu

        for (item in menu.iterator()) {
            item.apply { isChecked = itemId == actionId }
        }
    }

    override fun onBackPressed() {
        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (fragment != null && fragment is HomeFragment) {
            finish()
        } else {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                super.onBackPressed()
            }
        }
    }
}
