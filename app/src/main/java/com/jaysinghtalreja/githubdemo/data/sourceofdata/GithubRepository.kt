package com.jaysinghtalreja.githubdemo.data.sourceofdata

import androidx.lifecycle.LiveData
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.BoilVolume
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Ingredients
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Method
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Volume
import com.jaysinghtalreja.githubdemo.data.sourceofdata.model.Beer
import com.jaysinghtalreja.githubdemo.utils.async.ThreadManager
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val beerApi : BeerApi,
    private val threadManager: ThreadManager,
    private val githubRepositoryDataSourceLocal: GithubRepositoryDataSourceLocal
) {


    suspend fun getBeers() : Pair<List<Beer>?, Int> {
        return withContext(threadManager.io) {
            val response = beerApi.getGithubTrending()
            response.body() to response.code()
        }
    }

    fun getBeersLiveData() : LiveData<List<com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer>> {
        return githubRepositoryDataSourceLocal.getBeersLiveData()
    }

    suspend fun saveBeersLocal(beerList : List<com.jaysinghtalreja.githubdemo.data.sourceofdata.model.Beer>) {
        val beerEntities = beerList.map {
            com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer(
                id = it.id,
                firstBrewed = it.firstBrewed,
                attenuationLevel = it.attenuationLevel,
                method = Method(
                    mashTemp = it.method?.mashTemp,
                    fermentation = it.method?.fermentation,
                    twist = it.method?.twist
                ),
                targetOg = it.targetOg,
                imageUrl = it.imageUrl,
                boilVolume = BoilVolume(
                    unit = it.boilVolume?.unit,
                    value = it.boilVolume?.value
                ),
                ebc = it.ebc,
                description = it.description,
                targetFg = it.targetFg,
                srm = it.srm,
                volume = Volume(
                    unit = it.volume?.unit,
                    value = it.volume?.value
                ),
                contributedBy = it.contributedBy,
                abv = it.abv,
                foodPairing = it.foodPairing,
                name = it.name,
                ph = it.ph,
                tagline = it.tagline,
                ingredients = Ingredients(
                    hops = it.ingredients?.hops,
                    yeast = it.ingredients?.yeast,
                    malt = it.ingredients?.malt
                ),
                ibu = it.ibu,
                brewersTips = it.brewersTips
            )
        }
        githubRepositoryDataSourceLocal.insertBeersDAta(beerEntities)
    }



    companion object {
        private const val PARAM_QUERY = "q"
        private const val PARAM_SORT = "sort"
        private const val PARAM_ORDER = "order"
    }
}