package com.s2dioapps.metask.ui.component.tasktoday.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.s2dioapps.metask.databinding.FragmentTaskTodayBinding
import com.s2dioapps.metask.ui.component.setting.viewmodel.SettingViewModel
import com.s2dioapps.metask.ui.component.tasktoday.viewmodel.TaskTodayViewModel

class TaskTodayFragment : Fragment() {

    private lateinit var taskTodayViewModel: TaskTodayViewModel
    private var _binding: FragmentTaskTodayBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        taskTodayViewModel =
            ViewModelProvider(this).get(TaskTodayViewModel::class.java)

        _binding = FragmentTaskTodayBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}