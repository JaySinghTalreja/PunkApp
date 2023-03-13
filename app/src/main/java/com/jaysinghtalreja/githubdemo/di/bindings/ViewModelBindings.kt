package com.jaysinghtalreja.githubdemo.di.bindings

import androidx.lifecycle.ViewModel
import com.jaysinghtalreja.githubdemo.di.modules.viewmodel.ViewModelKey
import com.jaysinghtalreja.githubdemo.ui.landing.FragmentBeerTrendingViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBindings {

    @Binds
    @IntoMap
    @ViewModelKey(FragmentBeerTrendingViewModel::class)
    abstract fun bindForecastListViewModel(viewModel: FragmentBeerTrendingViewModel): ViewModel
}
