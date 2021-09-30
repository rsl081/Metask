package com.s2dioapps.metask.ui.component.home.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.FragmentHomeBinding
import com.s2dioapps.metask.ui.component.createtask.view.CreateTaskActivity
import com.s2dioapps.metask.ui.component.home.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })``

        binding.tvCreateNewtaskHome.setOnClickListener {
            startActivity(Intent(requireActivity(), CreateTaskActivity::class.java))
        }

        


        return root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}