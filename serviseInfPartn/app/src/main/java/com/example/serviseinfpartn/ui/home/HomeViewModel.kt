package com.example.serviseinfpartn.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.serviseinfpartn.data.api.ApiService
import com.example.serviseinfpartn.ui.home.paging.PagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val apiRepo: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        PagingSource(apiRepo)
    }.flow.cachedIn(viewModelScope)

}