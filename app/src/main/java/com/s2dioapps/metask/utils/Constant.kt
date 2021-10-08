package com.s2dioapps.metask.utils


import android.content.SharedPreferences
import com.s2dioapps.metask.R

object Constant {

    val clientId: String = R.string.com_auth0_client_id.toString()
    val domain: String = R.string.com_auth0_domain.toString()

    lateinit var MSHAREDPREFERENCES: SharedPreferences
    const val PREFERENCE_NAME = "MeTaskAppPreference"

    const val TOKEN: String = "MY_TOKEN"
}