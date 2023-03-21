package com.mnashat_dev.quraanzareem.ui.mainscreenfragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mnashat_dev.quraanzareem.R
import com.mnashat_dev.quraanzareem.databinding.FragmentMainScreenBinding
import com.mnashat_dev.quraanzareem.ui.data.listJuz
import com.mnashat_dev.quraanzareem.ui.data.listPage
import com.mnashat_dev.quraanzareem.ui.data.listSurh


class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var juzAdapter: JuzAdapter
    private lateinit var surhAdapter: SurhAdapter
    private lateinit var pageAdapter: PageAdapter
    private lateinit var sharedPrf: SharedPreferences
    private var lastRecycler = "rvSourh"
    private  var lastPage = 3

    override fun onResume() {
        super.onResume()
        Log.e("TAG","onResume")
    }

    override fun onStart() {
        super.onStart()
        when(lastRecycler){
            "rvSourh" -> onSurhClicked()
            "rvPages" -> onPageClicked()
            "rvJuz" -> onJuzClicked()
        }
        Log.e("TAG","onStart")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)

        sharedPrf = requireActivity().getSharedPreferences(getString(R.string.shardPrf),
            Context.MODE_PRIVATE)
        lastPage = sharedPrf.getInt(getString(R.string.last_page),3)

        binding.tvChooseJuz.setOnClickListener {
            onJuzClicked()
        }
        binding.tvChooseSorah.setOnClickListener {
            onSurhClicked()
        }
        binding.tvChoosePage.setOnClickListener {
            onPageClicked()
        }
        binding.tvSaved.setOnClickListener {
            onSavedClicked()
        }
        binding.appCompatImageView.setOnClickListener {
            onImageClicked()
        }

        return binding.root

    }

    private fun onPageClicked() {
        lastRecycler = "rvPages"
        binding.rvJuz.visibility = View.GONE
        binding.rvPages.visibility = View.VISIBLE
        binding.rvSourh.visibility = View.GONE
        binding.tvChoosePage.background = resources.getDrawable(R.drawable.round_shape)
        binding.tvChoosePage.setTextColor( resources.getColor(R.color.white))
        binding.tvChooseSorah.background = resources.getDrawable(R.drawable.bg_gray)
        binding.tvChooseSorah.setTextColor( resources.getColor(R.color.black))
        binding.tvChooseJuz.background = resources.getDrawable(R.drawable.bg_gray)
        binding.tvChooseJuz.setTextColor( resources.getColor(R.color.black))
    }

    private fun onSurhClicked() {
        lastRecycler = "rvSourh"
        binding.rvJuz.visibility = View.GONE
        binding.rvPages.visibility = View.GONE
        binding.rvSourh.visibility = View.VISIBLE
        binding.tvChoosePage.background = resources.getDrawable(R.drawable.bg_gray)
        binding.tvChoosePage.setTextColor( resources.getColor(R.color.black))
        binding.tvChooseSorah.background = resources.getDrawable(R.drawable.round_shape)
        binding.tvChooseSorah.setTextColor( resources.getColor(R.color.white))
        binding.tvChooseJuz.background = resources.getDrawable(R.drawable.bg_gray)
        binding.tvChooseJuz.setTextColor( resources.getColor(R.color.black))
    }

    private fun onJuzClicked() {
        lastRecycler = "rvJuz"
        binding.rvJuz.visibility = View.VISIBLE
        binding.rvPages.visibility = View.GONE
        binding.rvSourh.visibility = View.GONE
        binding.tvChoosePage.background = resources.getDrawable(R.drawable.bg_gray)
        binding.tvChoosePage.setTextColor( resources.getColor(R.color.black))
        binding.tvChooseSorah.background = resources.getDrawable(R.drawable.bg_gray)
        binding.tvChooseSorah.setTextColor( resources.getColor(R.color.black))
        binding.tvChooseJuz.background = resources.getDrawable(R.drawable.round_shape)
        binding.tvChooseJuz.setTextColor( resources.getColor(R.color.white))
    }

    private fun onSavedClicked() {
        findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragmentToSavedFragment())

    }

    private fun onImageClicked() {
        findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragmentToReadingFragment(0))

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeAdapters()
        setUpRecyclerViews()
    }


    private fun initializeAdapters() {

        juzAdapter = JuzAdapter(JuzListener {
            findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragmentToReadingFragment(it.page))
        })
        juzAdapter.submitList(listJuz)

        surhAdapter = SurhAdapter(SurhListener {
            findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragmentToReadingFragment(it.page))
        })
        surhAdapter.submitList(listSurh)

        pageAdapter = PageAdapter(PageListener {
            findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragmentToReadingFragment(it.number.toInt().plus(2)))
        })
        pageAdapter.submitList(listPage)
    }

    private fun setUpRecyclerViews() {

        val numberOfColumns = 3
        binding.rvPages.layoutManager = GridLayoutManager(requireContext(), numberOfColumns)
        binding.rvPages.adapter = pageAdapter
        binding.rvSourh.adapter = surhAdapter
        binding.rvJuz.adapter = juzAdapter
    }

}