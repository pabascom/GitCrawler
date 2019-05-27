package phil.homework.gitcrawler.model.data.remote

import kotlinx.coroutines.Deferred
import phil.homework.gitcrawler.model.entity.result.RepositorySearchResult
import phil.homework.gitcrawler.model.entity.result.RepositorySummary
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET(REPOSITORY_SEARCH_PATH)
    fun searchRepositories(
        @Query(REPOSITORY_QUERY_IDENTIFIER) query: String,
        @Query(REPOSITORY_SORT_IDENTIFIER) sortingOption: String
    ): Deferred<RepositorySearchResult>
}