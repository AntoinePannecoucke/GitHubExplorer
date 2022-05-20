package fr.lpiem.githubexplorer.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import fr.lpiem.githubexplorer.core.model.Repository
import fr.lpiem.githubexplorer.data.datasource.RepositoryRemoteDataSource

class RepositoryPagingSource(
    private val repositoryRemoteDataSource: RepositoryRemoteDataSource,
) : PagingSource<Int, Repository>() {

    var userId: Int = 0

    companion object {
        private const val TAG = "RepositoryPagingSource"
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response =
                repositoryRemoteDataSource.getRepositoriesOf(nextPageNumber, userId).getOrNull()
            LoadResult.Page(
                data = response?.second ?: listOf(),
                prevKey = null,
                nextKey = response?.first
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Repository>): Int? {
        return null
    }

}