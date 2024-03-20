package com.example.serviseinfpartn.ui.home.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.serviseinfpartn.data.api.ApiService
import com.example.serviseinfpartn.data.models.ResponseApiItem

class PagingSource(private val apiDoctorsRepo: ApiService) :
    PagingSource<Int, ResponseApiItem>() {
    override fun getRefreshKey(state: PagingState<Int, ResponseApiItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseApiItem> {
        return try {
            val currentPage = params.key ?: 1
            val data = apiDoctorsRepo.getAll().body()?: emptyList()
//            val data = response
            val responseData = mutableListOf<ResponseApiItem>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1 ,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}