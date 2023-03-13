package com.jaysinghtalreja.githubdemo.ui.landing

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jaysinghtalreja.githubdemo.data.sourceofdata.GithubRepository
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer
import com.jaysinghtalreja.githubdemo.ui.common.UiState
import com.jaysinghtalreja.githubdemo.ui.common.UiStateViewModel
import com.jaysinghtalreja.githubdemo.utils.Constants
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentBeerTrendingViewModel @Inject constructor(private val githubRepository: GithubRepository) : UiStateViewModel() {

    val beers = githubRepository.getBeersLiveData()
    val selectedBeer = MutableLiveData<Beer>(null)
    val isKnowMoreGone = ObservableBoolean(true)
    val orientationVertical = ObservableBoolean(true)


    fun getBeersData() {
        viewModelScope.launch {
            uiState = UiState.INIT
            val(response, statusCode) = try {
                githubRepository.getBeers()
            }
            catch (e : Exception) {
                uiState = UiState.ERROR
                null to 0
            }

            if(statusCode == Constants.RESPONSE_200_SUCCESS) {
                response?.let { beersList ->
                    beersList?.forEach {
                        Log.i("Beers", "getBeersData: " + it.toString())
                    }
                    if(beersList.size == 0) {
                        uiState = UiState.EMPTY
                    }
                    else {
                        uiState = UiState.LOADED
                    }
                    githubRepository.saveBeersLocal(beersList)
                }
            }
        }
    }
}