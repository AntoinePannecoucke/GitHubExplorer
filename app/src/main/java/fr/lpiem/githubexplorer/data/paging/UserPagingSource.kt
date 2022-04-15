package fr.lpiem.githubexplorer.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.data.datasource.UserRemoteDataSource
import java.lang.Exception

class UserPagingSource(
    private val userRemoteDataSource: UserRemoteDataSource
) : PagingSource<Int, User>() {

    companion object {
        private const val TAG = "UserPagingSource"
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = userRemoteDataSource.getUsersAtPage(nextPageNumber).getOrNull()
            return LoadResult.Page(
                data = response?.second ?: listOf(),
                prevKey = null,
                nextKey = response?.first
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }

}
