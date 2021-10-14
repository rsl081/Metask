package com.s2dioapps.metask.ui.component.home.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.s2dioapps.metask.data.model.user.User
import com.s2dioapps.metask.databinding.FragmentHomeBinding
import com.s2dioapps.metask.ui.component.createtask.view.CreateTaskActivity
import com.s2dioapps.metask.ui.component.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class HomeFragment() : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.tvCreateNewtaskHome.setOnClickListener {
            startActivity(Intent(requireActivity(), CreateTaskActivity::class.java))
        }

        homeViewModel.loginResponse()?.enqueue(object: Callback<User> {
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful) {

                    val nickname  = response.body()?.nickname
                    val picture = response.body()?.picture

                    if (nickname != null) {
                        binding.tvNameActivityDay.text = "Hello, $nickname"
                    }

                    if (picture != null) {
                        Glide
                            .with(requireActivity())
                            .load(picture)
                            .centerCrop()
                            .into(binding.ivCircle)
                    }
                }else{
                    val rc =  response.code()
                    when(rc){
                        400->{
                            Log.e("Error 400", "Bad Request")
                        }
                        404-> {
                            Log.e("Error 404", "Not Found")
                        }else ->{

                        Toast.makeText(activity, "Wrong username or password", Toast.LENGTH_SHORT).show()
                        Log.e("Error", "Generic Error" + rc)
                    }
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Errorrrrr", t!!.message.toString())
                //hideProgressDialog()
            }
        })


        return root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}