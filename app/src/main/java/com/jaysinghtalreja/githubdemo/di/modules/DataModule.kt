package com.jaysinghtalreja.githubdemo.di.modules

import android.app.Application
import com.jaysinghtalreja.githubdemo.data.GithubLocalDatabase
import com.jaysinghtalreja.githubdemo.data.sourceofdata.dao.BeerDao
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesBeersDao(application: Application) : BeerDao =
            GithubLocalDatabase.getInstance(application).beerDao()
    }

}