package com.example.serviseinfpartn.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.serviseinfpartn.MainActivity
import com.example.serviseinfpartn.R
import com.example.serviseinfpartn.data.models.ResponseApiItem
import com.example.serviseinfpartn.databinding.FragmentHomeBinding
import com.example.serviseinfpartn.ui.home.adapter.PagedAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var usersAdapter: PagedAdapter
    private lateinit var homeViewModel: HomeViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRV()
        loadingData()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadingData() {
        lifecycleScope.launch {
            homeViewModel.listData.collect { pagingData ->
                usersAdapter.submitData(pagingData)

            }
        }
    }

    fun onItemClick(item: ResponseApiItem) {

        val bundle = Bundle().apply {
            putString("param1", item.name)
            putString("param2", item.username)
            putString("param3", item.email)
            putString("param4", item.phone)
            putString("param5", item.website)
            putString("param6", item.address.street)
            putString("param7", item.address.suite)
            putString("param8", item.address.city)
            putString("param9", item.address.zipcode)
            putString("param10", item.address.geo.lat)
            putString("param11", item.address.geo.lng)
            putString("param12", item.company.name)
            putString("param13", item.company.catchPhrase)
            putString("param14", item.company.bs)
        }

        findNavController().navigate(R.id.action_navigation_home_to_userInfoFragment, bundle)
    }

    private fun setupRV() {

        Log.d("qwerty", "ok")
        usersAdapter = PagedAdapter { ResponseApiItem -> onItemClick(ResponseApiItem) }

        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL
            )
            adapter = usersAdapter
            setHasFixedSize(true)
        }
    }
}