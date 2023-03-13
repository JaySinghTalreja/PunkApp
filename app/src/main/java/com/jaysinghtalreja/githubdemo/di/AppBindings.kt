package com.jaysinghtalreja.githubdemo.di

import com.jaysinghtalreja.githubdemo.MainActivity
import com.jaysinghtalreja.githubdemo.di.bindings.FragmentBindings
import com.jaysinghtalreja.githubdemo.di.bindings.ViewModelBindings
import com.jaysinghtalreja.githubdemo.utils.async.ThreadManager
import com.jaysinghtalreja.githubdemo.utils.async.ThreadManagerImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindings {

    @ContributesAndroidInjector(
        modules = [
            FragmentBindings::class,
            ViewModelBindings::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    @Binds
    abstract fun provideThreadManager(threadManager: ThreadManagerImpl): ThreadManager
}