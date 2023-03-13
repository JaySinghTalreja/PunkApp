package com.jaysinghtalreja.githubdemo.data.sourceofdata

import androidx.lifecycle.LiveData
import com.jaysinghtalreja.githubdemo.data.sourceofdata.dao.BeerDao
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer
import javax.inject.Inject

class GithubRepositoryDataSourceLocal @Inject constructor(val beerDao: BeerDao) {

    /**
     * Get Beer List Live Data
     */
    fun getBeersLiveData() : LiveData<List<Beer>> {
        return beerDao.getAllBeers()
    }

    /**
     * Insert into beers table
     */
    open suspend fun insertBeersDAta(listBeers : List<Beer>) {
        beerDao.insertAll(listBeers)
    }
}