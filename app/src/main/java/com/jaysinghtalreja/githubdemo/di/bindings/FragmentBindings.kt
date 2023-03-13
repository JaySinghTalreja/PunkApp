package com.jaysinghtalreja.githubdemo.di.bindings

import com.jaysinghtalreja.githubdemo.ui.landing.FragmentGithubTrending
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindings {
    
    @ContributesAndroidInjector
    abstract fun contributeGithubTrendingFragment(): FragmentGithubTrending

}
