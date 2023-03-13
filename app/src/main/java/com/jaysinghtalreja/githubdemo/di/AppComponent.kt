package com.jaysinghtalreja.githubdemo.di

import android.app.Application
import com.jaysinghtalreja.githubdemo.GithubDemo
import com.jaysinghtalreja.githubdemo.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppBindings::class
    ]
)
interface AppComponent : AndroidInjector<GithubDemo> {
    fun inject(app: Application)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun app(app: Application): Builder

        fun build(): AppComponent
    }

}