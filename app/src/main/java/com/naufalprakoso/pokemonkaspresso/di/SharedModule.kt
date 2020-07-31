package com.naufalprakoso.pokemonkaspresso.di

import com.naufalprakoso.pokemonkaspresso.network.ServiceBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class SharedModule {

    @Singleton
    @Provides
    fun provideServiceBuilder() = ServiceBuilder()

}