package com.s2dioapps.metask.di

import android.content.Context
import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.data.api.OrganizationApi
import com.s2dioapps.metask.data.api.TaskApi
import com.s2dioapps.metask.data.repository.LoginRepositoryImpl
import com.s2dioapps.metask.data.repository.MemberRepositoryImpl
import com.s2dioapps.metask.data.repository.TaskRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.internal.concurrent.Task
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
     fun provideLoginRepository(): LoginApi {
        return LoginRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(): TaskApi {
        return TaskRepositoryImp()
    }

    @Provides
    @Singleton
    fun provideMemberRepository(): OrganizationApi {
        return MemberRepositoryImpl()
    }



}