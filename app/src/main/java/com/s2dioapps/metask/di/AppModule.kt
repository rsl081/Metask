package com.s2dioapps.metask.di

import android.content.Context
import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.data.repository.LoginRepositoryImpl
import com.s2dioapps.metask.data.repository.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
     fun provideLoginRepository(): LoginApi {
        return LoginRepositoryImpl()
    }

}