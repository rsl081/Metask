package com.s2dioapps.metask.ui.component.register.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.ActivityLoginBinding
import com.s2dioapps.metask.databinding.FragmentFullNameBinding
import com.s2dioapps.metask.databinding.FragmentUsernameBinding
import com.s2dioapps.metask.ui.component.register.viewmodel.RegisterViewModel

class UsernameFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

    private lateinit var _binding: FragmentUsernameBinding

    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        registerViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        _binding = FragmentUsernameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        val progressBar = activity?.findViewById<ProgressBar>(R.id.pb_register)

        binding.buttonNext.setOnClickListener {
            viewPager?.setCurrentItem(2, true)
        }

        binding.tvBack.setOnClickListener {
            viewPager?.setCurrentItem(0, true)
        }



        return root
    }

}