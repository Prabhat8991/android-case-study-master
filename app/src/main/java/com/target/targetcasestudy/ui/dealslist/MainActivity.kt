package com.target.targetcasestudy.ui.dealslist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.ActivityMainBinding
import com.target.targetcasestudy.ui.payment.PaymentDialogFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

  lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    val navHostFragment = nav_host_fragment as NavHostFragment
    navController = navHostFragment.navController
    val appBarConfiguration = AppBarConfiguration(navController.graph)
    binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    NavigationUI.setupActionBarWithNavController(this, navController)
    val view = binding.root
    setContentView(view)
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.credit_card -> {
        PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
        true
      }
      else -> false
    }
  }
}
