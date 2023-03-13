package com.jaysinghtalreja.githubdemo.ui.explore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jaysinghtalreja.githubdemo.R
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer
import com.jaysinghtalreja.githubdemo.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private lateinit var binding : FragmentExploreBinding
//    private val args: ExploreFragmentArgs by navArgs()
    private lateinit var beer : Beer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        beer = args.beer
//        Log.i(FRAGMENT_ID, "onCreate: " + beer.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object {
        const val FRAGMENT_ID = "ExploreFragment"
    }


}