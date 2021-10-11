package com.s2dioapps.metask.di

import android.content.Context
import com.s2dioapps.metask.data.repository.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideLocalRepository(@ApplicationContext context: Context): UserPreferences {
        return UserPreferences(context)
    }

}