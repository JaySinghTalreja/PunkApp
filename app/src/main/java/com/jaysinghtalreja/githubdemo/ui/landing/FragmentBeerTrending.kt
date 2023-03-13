package com.jaysinghtalreja.githubdemo.ui.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer
import com.jaysinghtalreja.githubdemo.databinding.FragmentBeerTrendingBinding
import com.jaysinghtalreja.githubdemo.di.modules.viewmodel.ViewModelFactory
import com.jaysinghtalreja.githubdemo.ui.common.UiState
import com.jaysinghtalreja.githubdemo.ui.landing.adapters.GithubRepositoryAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FragmentGithubTrending : DaggerFragment(), ItemSelectionListener, OnRepositorySearchListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding : FragmentBeerTrendingBinding

    private lateinit var adapter : GithubRepositoryAdapter


    private val fragmentBeerTrendingViewModel : FragmentBeerTrendingViewModel by viewModels { viewModelFactory }
    private var layoutManager : LinearLayoutManager? = null
    private lateinit var beerList : List<Beer>
    private var selectedBeer : Beer? = null
    private var recyclerViewPosition: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restoreAdapterPosition(savedInstanceState)

    }

    /**
     * Restore Adapter's Last Visible Item Position
     */
    private fun restoreAdapterPosition(savedInstanceState: Bundle?) {
        savedInstanceState?.getInt(ADAPTER_POSITION).let {
            recyclerViewPosition = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBeerTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initData()
        initView()
        initObservers()
    }


    override fun onResume() {
        super.onResume()
        recyclerViewPosition?.let {position ->
            updateRecyclerViewPosition(position)
        }
    }

    private fun initData() {
        fragmentBeerTrendingViewModel.getBeersData()
    }

    private fun initAdapter() {
        layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        layoutManager?.orientation = if(fragmentBeerTrendingViewModel.orientationVertical.get()) {
            LinearLayoutManager.VERTICAL
        }
        else {
            LinearLayoutManager.HORIZONTAL
        }
        binding.repoRv.layoutManager = layoutManager
        adapter = GithubRepositoryAdapter(this, this)
        binding.repoRv.adapter = adapter
    }

    private fun initView() {
        with(binding) {
            binding.viewModel = fragmentBeerTrendingViewModel
            binding.isKnowMoreGone = fragmentBeerTrendingViewModel.isKnowMoreGone

            binding.searchRefuelerTv.doOnTextChanged { text, _, _, _t ->
                adapter.filter.filter(text)
            }

            binding.repoRv.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    recyclerViewPosition = layoutManager?.findFirstVisibleItemPosition()
                }
            })

            binding.about.setOnClickListener {
                val directions = FragmentGithubTrendingDirections.navigationListToAboutPage()
                findNavController().navigate(directions)
            }

        }
    }



    private fun initObservers() {

        fragmentBeerTrendingViewModel.beers.observe(viewLifecycleOwner, Observer {
            beerList = it
            checkForSelectedRepository(beerList)
            adapter.submitList(it)
            adapter.beerList = it
        })

        fragmentBeerTrendingViewModel.selectedBeer.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                fragmentBeerTrendingViewModel.isKnowMoreGone.set(false)
            }
            selectedBeer = it
        })

    }

    private fun checkForSelectedRepository(beerList: List<Beer>?) {
        selectedBeer?.let {
            beerList?.forEach { item ->
                if (item.id == selectedBeer!!.id) {
                    item.apply {
                        isSelected = true
                    }
                }
            }
        }
    }

    override fun onSelectItem(item: Beer) {
        beerList.forEach {
            it.isSelected = false
        }
        item.isSelected = true
        fragmentBeerTrendingViewModel.selectedBeer.value = item
        adapter.notifyDataSetChanged()
    }


    override fun hasData(found: Boolean) {
        if(found) {
            fragmentBeerTrendingViewModel.uiState = UiState.LOADED
        }
        else {
            fragmentBeerTrendingViewModel.uiState = UiState.EMPTY
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        recyclerViewPosition?.let {
            outState.putInt(ADAPTER_POSITION , it)
        }
    }


    private fun updateRecyclerViewPosition(position: Int) {
        binding.repoRv.scrollToPosition(position)
    }

    /**
     * Static
     */
    companion object {
        const val FRAGMENT_ID = "GitHubTrending"
        const val ADAPTER_POSITION = "adapter_position"
    }

}

interface ItemSelectionListener {
    fun onSelectItem(item : Beer)
}

interface OnRepositorySearchListener {
    fun hasData(found : Boolean)
}
