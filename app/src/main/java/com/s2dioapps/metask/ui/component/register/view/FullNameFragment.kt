package com.s2dioapps.metask.ui.component.register.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.ActivityLoginBinding
import com.s2dioapps.metask.databinding.ActivityRegisterBinding
import com.s2dioapps.metask.databinding.FragmentFullNameBinding
import com.s2dioapps.metask.ui.component.home.viewmodel.HomeViewModel
import com.s2dioapps.metask.ui.component.register.viewmodel.RegisterViewModel

class FullNameFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var binding: FragmentFullNameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding = FragmentFullNameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        binding.buttonNext.setOnClickListener {
            viewPager?.setCurrentItem(1, true)

        }


    }
}