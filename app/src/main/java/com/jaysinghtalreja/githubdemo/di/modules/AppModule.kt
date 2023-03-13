package com.jaysinghtalreja.githubdemo.di.modules

import android.app.Application
import com.jaysinghtalreja.githubdemo.GithubDemo
import com.jaysinghtalreja.githubdemo.di.modules.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(
    includes = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        NetModule::class,
        DataModule::class
    ]
)
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application: Application): GithubDemo = application as GithubDemo
}
