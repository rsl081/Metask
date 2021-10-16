package com.s2dioapps.metask.utils


import android.content.SharedPreferences
import com.auth0.android.Auth0
import com.s2dioapps.metask.R

object Constant {

    val clientId: String = R.string.com_auth0_client_id.toString()
    val domain: String = R.string.com_auth0_domain.toString()

    const val BASE_URL_AUTH: String = "https://dev-eb4zk63w.us.auth0.com/"
    const val BASE_URL: String = "http://192.168.100.37:60001/api/"

    lateinit var MSHAREDPREFERENCES: SharedPreferences
    const val PREFERENCE_NAME = "MeTaskAppPreference"

    const val TOKEN: String = "MY_TOKEN"

    var ORG_ID: String = "org_id"

    lateinit var account: Auth0
}