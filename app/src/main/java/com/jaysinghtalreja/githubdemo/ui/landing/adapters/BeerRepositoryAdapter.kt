package com.jaysinghtalreja.githubdemo.ui.landing.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer
import com.jaysinghtalreja.githubdemo.databinding.RepositoryItemBinding
import com.jaysinghtalreja.githubdemo.ui.landing.ItemSelectionListener
import com.jaysinghtalreja.githubdemo.ui.landing.OnRepositorySearchListener
import java.util.*

class GithubRepositoryAdapter(private val itemSelectionListener: ItemSelectionListener, private val repositorySearchListener: OnRepositorySearchListener) : ListAdapter<Beer, GithubRepositoryAdapter.GithubRepositoryViewHolder>(GithubRepositoryDataDiffCallback()), Filterable {

    var beerList: List<Beer> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepositoryViewHolder {
        return GithubRepositoryViewHolder(
            RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    override fun onBindViewHolder(holder: GithubRepositoryViewHolder, position: Int) {
        val repositoryItem = getItem(position)
        holder.bind(repositoryItem, itemSelectionListener)
    }

    class GithubRepositoryViewHolder(private val binding : RepositoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(beerItem : Beer, itemSelectionListener: ItemSelectionListener) {
            binding.apply {
                this.theBeer = beerItem
            }
            binding.card.setOnClickListener {
                itemSelectionListener.onSelectItem(beerItem)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredBeerList: MutableList<Beer> = ArrayList()
                val filterResults = FilterResults()

                if (constraint == null || constraint.isEmpty()) {
                    filteredBeerList.addAll(beerList)
                } else {
                    val beerSearchItem = constraint.toString().toLowerCase(Locale.getDefault())
                        .trim { it <= ' ' }
                    for (beer in beerList) {
                        if(beer.name?.toLowerCase(Locale.getDefault())!!.contains(beerSearchItem) || beer.description?.toLowerCase(Locale.getDefault())!!.contains(beerSearchItem)) {
                            filteredBeerList.add(beer)
                        }
                    }
                }
                filterResults.values = filteredBeerList

                /**
                 * Toggle Search Results UiState
                 */
                if(filteredBeerList.size == 0) {
                    repositorySearchListener.hasData(false)
                }
                else {
                    repositorySearchListener.hasData(true)
                }
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                submitList(results?.values as List<Beer>)
                notifyDataSetChanged()
            }
        }
    }

}

class GithubRepositoryDataDiffCallback: DiffUtil.ItemCallback<Beer>(){
    override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
        return oldItem == newItem
    }
}