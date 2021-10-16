package com.s2dioapps.metask.data.model.user

data class User(
    val access_token: String?,
    val given_name: String,
    val family_name: String,
    val nickname: String,
    val picture: String,
    val created_at: String,
    val email: String,
    val email_verified_at: Any,
    val sub: String,
    val name: String,
    val org_id: String,
    val updated_at: String
)