package com.s2dioapps.metask.ui.component.register.view

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
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
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_DRAGGING
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.ActivityLoginBinding
import com.s2dioapps.metask.databinding.ActivityRegisterBinding
import com.s2dioapps.metask.databinding.FragmentFullNameBinding
import com.s2dioapps.metask.ui.component.register.adapter.RegisterAdapter
import com.s2dioapps.metask.ui.component.register.viewmodel.RegisterViewModel


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var _bidning: FragmentFullNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList = arrayListOf<Fragment>(
            FullNameFragment(),
            UsernameFragment(),
            EmailFragment(),
            PasswordFragment()
        )

        val adapter = RegisterAdapter(fragmentList, this)
        binding.viewPager.adapter = adapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
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

    override fun onBackPressed() {
        if(binding.viewPager.currentItem == 0) {
            super.onBackPressed()
        }else{
            binding.viewPager.currentItem = binding.viewPager.currentItem - 1
        }
    }
}