package com.s2dioapps.metask.ui.component.register.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.add
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.ActivityLoginBinding
import com.s2dioapps.metask.databinding.ActivityRegisterBinding
import com.s2dioapps.metask.ui.component.register.adapter.RegisterAdapter
import com.s2dioapps.metask.ui.component.register.viewmodel.RegisterViewModel


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        val fragmentList = arrayListOf<Fragment>(
            FullNameFragment(),
            UsernameFragment(),
            EmailFragment(),
            PasswordFragment()
        )

        val adapter = RegisterAdapter(fragmentList, this)
        viewPager.adapter = adapter


        //val progressBar = this.findViewById<ProgressBar>(R.id.pb_register)


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.pbRegister.setProgress(25,true)
                        binding.tvAlreadyHaveAnAccount.visibility = View.VISIBLE
                        binding.tvSignIn.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.pbRegister.setProgress(50,true)
                        binding.tvAlreadyHaveAnAccount.visibility = View.VISIBLE
                        binding.tvSignIn.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.pbRegister.setProgress(75,true)
                        binding.tvAlreadyHaveAnAccount.visibility = View.VISIBLE
                        binding.tvSignIn.visibility = View.VISIBLE
                    }
                    3 -> {
                        binding.pbRegister.setProgress(100,true)
                        binding.tvAlreadyHaveAnAccount.visibility = View.INVISIBLE
                        binding.tvSignIn.visibility = View.INVISIBLE
                    }
                }
                super.onPageSelected(position)
            }
        })




    }






}