package com.s2dioapps.metask.ui.component.main.view

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.s2dioapps.metask.R
import com.s2dioapps.metask.data.repository.UserPreferences
import com.s2dioapps.metask.databinding.ActivityMainBinding
import com.s2dioapps.metask.ui.base.view.BaseActivity
import com.s2dioapps.metask.ui.base.viewmodel.BaseViewModel
import com.s2dioapps.metask.ui.component.login.viewmodel.LoginViewModel
import com.s2dioapps.metask.ui.component.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : BaseActivity() {

    //private val mMainViewModel: MainViewModel by viewModels()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun observeViewModel() {}

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this.mMainViewModel = ViewModelProvider(this).get(mMainViewModel::class.java)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Log.i("happy token", mMainViewModel.token.toString())

        val userPreferences = UserPreferences(this)

        userPreferences.accessToken.asLiveData().observe(this, Observer {
//            val activity = if (it == null) AuthActivity::class.java else HomeActivity::class.java
//            startNewActivity(activity)
            if (it != null) {
                Log.i("happyToken", "qweqwe $it")
            }
        })

    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        //Set color ng side navigation bar
        if (parent?.parent is FrameLayout) {
            (parent?.parent as View).setBackgroundColor(getColor(R.color.mariner))
        }

        return super.onCreateView(parent, name, context!!, attrs)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        var item = menu.findItem(R.id.action_date)
        //item.title = mMainViewModel.displayCurrentDate()
        for (i in 0 until menu.size()) {
            val item = menu.getItem(i)
            val spanString = SpannableString(menu.getItem(i).title.toString())

            spanString.setSpan(
                ForegroundColorSpan(getColor(R.color.matterhorn)),
                0,
                spanString.length,
                0
            ) //fix the color to matterhorn

            item.title = spanString
        }

        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.action_date->{
//                item.title = "goods"
//                Toast.makeText(applicationContext, "Happy!", Toast.LENGTH_SHORT).show();
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}