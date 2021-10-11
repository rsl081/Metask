package com.s2dioapps.metask.ui.component.login.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.s2dioapps.metask.R
import com.s2dioapps.metask.databinding.ActivityLoginBinding
import com.s2dioapps.metask.ui.base.view.BaseActivity
import com.s2dioapps.metask.ui.component.login.viewmodel.LoginViewModel
import com.s2dioapps.metask.ui.component.main.view.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject


class LoginActivity : BaseActivity() {

    private val TAG = "LoginActivity"

    private lateinit var account: Auth0

    private lateinit var binding: ActivityLoginBinding
    private var cachedCredentials: Credentials? = null
    private var cachedUserProfile: UserProfile? = null
    @Inject lateinit var mLoginViewModel: LoginViewModel

    //private lateinit var mLoginViewModel: LoginViewModel

    //val dataStorePreferenceRepository: DataStorePreferenceRepository = DataStorePreferenceRepository.getInstance(this)


    override fun observeViewModel() {}

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        //mLoginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val clientId: String = getString(R.string.com_auth0_client_id)
        val domain: String = getString(R.string.com_auth0_domain)

        account = Auth0(
            clientId,
            domain
        )

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignIn.setOnClickListener { loginWithBrowser() }
        // binding.btnCreateAccount.setOnClickListener { logout() }
    }


    private fun loginWithBrowser() {
        // Setup the WebAuthProvider, using the custom scheme and scope.

        val callback = object : Callback<Credentials, AuthenticationException> {

            override fun onFailure(exception: AuthenticationException) {
                Log.d(TAG, "onFailure: ${exception.getDescription()}")
            }

            override fun onSuccess(credentials: Credentials) {
                Log.d( TAG, "onSuccess: Access Token = ${credentials.accessToken}")
                Log.d(TAG, "onSuccess: Id Token = ${credentials.idToken}")
                Log.d(TAG, "onSuccess: Scopes = ${credentials.scope}")

                CoroutineScope(Dispatchers.IO).async {
                    mLoginViewModel.saveAccessTokens(credentials.accessToken)
                    Log.d("tokensaved", "qwe" + mLoginViewModel.saveAccessTokens(credentials.accessToken).toString())
                }

                navigateToMainScreen()
            }

        }

        WebAuthProvider.login(account)
            .withScope("openid profile email read:current_user update:current_user_metadata")
            // specify the audience for the Auth0 Management API
            .withAudience("https://metask/api")
            .start(this, callback)
    }

//    private fun logout() {
//        WebAuthProvider.logout(account)
//            .withScheme(getString(R.string.com_auth0_scheme))
//            .start(this, object : Callback<Void?, AuthenticationException> {
//                override fun onSuccess(payload: Void?) {
//                    // The user has been logged out!
//                    cachedCredentials = null
//                    cachedUserProfile = null
//                    updateUI()
//                }
//
//                override fun onFailure(exception: AuthenticationException) {
//                    updateUI()
//                    showSnackBar("Failure: ${exception.getCode()}")
//                }
//            })
//    }

    private fun navigateToMainScreen() {
        val nextScreenIntent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(nextScreenIntent)
        finish()

    }


}