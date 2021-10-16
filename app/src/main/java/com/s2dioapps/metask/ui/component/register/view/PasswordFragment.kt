package com.s2dioapps.metask.ui.component.register.view

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.FragmentEmailBinding
import com.s2dioapps.metask.databinding.FragmentPasswordBinding
import com.s2dioapps.metask.databinding.FragmentUsernameBinding
import com.s2dioapps.metask.ui.component.register.viewmodel.RegisterViewModel


class PasswordFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var _binding: FragmentPasswordBinding

    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        val progressBar = activity?.findViewById<ProgressBar>(R.id.pb_register)


        binding.tvBack.setOnClickListener {
            viewPager?.setCurrentItem(2, true)
        }


        binding.etConfirmPassword.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    binding.buttonSubmit.isEnabled = s.isNotEmpty()
                }else{
                    binding.buttonSubmit.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })




        return root
    }
}