package com.mnashat_dev.quraanzareem.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.mnashat_dev.quraanzareem.R
import com.mnashat_dev.quraanzareem.databinding.FragmentReadingBinding


class ReadingFragment : Fragment() {

    private lateinit var sharedPrf: SharedPreferences
    private lateinit var binding: FragmentReadingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reading, container, false)
        val args: ReadingFragmentArgs by navArgs()

        sharedPrf = requireActivity().getSharedPreferences(
            getString(R.string.shardPrf), Context.MODE_PRIVATE
        )

        binding.pdfView.fromAsset("quran2.pdf").apply {
            defaultPage((613).minus(args.numberOfPage))
                swipeHorizontal(true)
            pageSnap(true)
            autoSpacing(true)
            pageFling(true)
                .pageFitPolicy(FitPolicy.BOTH)

//            nightMode(true)

            load()
        }
        return binding.root
    }

    override fun onStop() {
        super.onStop()
        sharedPrf.edit().apply() {
            putInt(getString(R.string.last_page),(binding.pdfView.currentPage))
            apply()
        }
        Log.e("TAG", " ${binding.pdfView.currentPage}")
    }


}