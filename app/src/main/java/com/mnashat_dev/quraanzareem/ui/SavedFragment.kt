package com.mnashat_dev.quraanzareem.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.mnashat_dev.quraanzareem.R
import com.mnashat_dev.quraanzareem.databinding.FragmentSavedBinding

class SavedFragment : Fragment() {

    private lateinit var sharedPrf: SharedPreferences
    private lateinit var binding: FragmentSavedBinding
    private  var lastPage = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saved, container, false)
//        val args: SavedFragmentArgs by navArgs()


        sharedPrf = requireActivity().getSharedPreferences(getString(R.string.shardPrf),
            Context.MODE_PRIVATE)
        lastPage = sharedPrf.getInt(getString(R.string.last_page),3)
        Log.e("TAG", " $lastPage")

        binding . pdfView . fromAsset ("quran2.pdf").apply {
            defaultPage(lastPage)
            swipeHorizontal(true)
            pageSnap(true)
            autoSpacing(true)
            pageFling(true)
            load()
        }

        return binding.root
    }

}