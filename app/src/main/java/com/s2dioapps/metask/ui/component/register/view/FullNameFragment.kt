package com.s2dioapps.metask.ui.component.register.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.s2dioapps.metask.ui.component.login.view.LoginActivity
import com.s2dioapps.metask.ui.component.register.viewmodel.RegisterViewModel
import android.view.MotionEvent

import androidx.viewpager.widget.ViewPager




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

        binding.buttonNext.isEnabled = false

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        binding.buttonNext.setOnClickListener {
            viewPager?.setCurrentItem(1, true)
        }

        binding.tvCancel.setOnClickListener{
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
        }

        binding.etFullName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    binding.buttonNext.isEnabled = s.isNotEmpty()
                }else{
                    binding.buttonNext.isEnabled = false
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })



    }
}