package fr.lpiem.githubexplorer.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import fr.lpiem.githubexplorer.core.model.User
import fr.lpiem.githubexplorer.data.datasource.UserRemoteDataSource

class UserPagingSource(
    private val userRemoteDataSource: UserRemoteDataSource
) : PagingSource<Int, User>() {

    companion object {
        private const val TAG = "UserPagingSource"
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val nextSince = params.key ?: 0
            val response = userRemoteDataSource.getUsersSince(nextSince).getOrNull()
            LoadResult.Page(
                data = response?.second ?: listOf(),
                prevKey = null,
                nextKey = response?.first
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }

}
