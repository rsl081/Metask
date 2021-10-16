package com.s2dioapps.metask.data.repository


import com.s2dioapps.metask.data.api.OrganizationApi
import com.s2dioapps.metask.data.model.user.Member
import com.s2dioapps.metask.data.network.RetrofitApiService
import com.s2dioapps.metask.utils.Constant
import retrofit2.Call
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(): OrganizationApi {


    override fun getMembers(id: String): Call<List<Member>>? =
        Constant.MSHAREDPREFERENCES.getString(Constant.TOKEN, "")?.let {
            RetrofitApiService().getMembersServiceHeader(
                it
            )
        }?.getMembers(id)


}