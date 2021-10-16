package com.s2dioapps.metask.ui.component.settings.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.FragmentSettingsBinding
import com.s2dioapps.metask.ui.component.login.view.LoginActivity
import com.s2dioapps.metask.ui.component.settings.viewmodel.SettingsViewModel
import com.s2dioapps.metask.utils.Constant

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textSlideshow
//        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        binding.tvSignout.setOnClickListener {
            settingsViewModel.signOut()
        }
        return root
    }

    private fun logout() {

        WebAuthProvider.logout(Constant.account)
            .start(requireContext(), object : Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    // The user has been logged out!
                    //Log.i("Successs","Failure: ${payload}")
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                }

                override fun onFailure(exception: AuthenticationException) {
                    Log.i("ClientID",Constant.account.clientId)
                    Log.i("ErrorLogout","Failure: ${exception.getDescription()}")
                }
            })
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}