package phil.homework.gitcrawler.model.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import phil.homework.gitcrawler.model.entity.result.RepositorySearchResult
import phil.homework.gitcrawler.model.entity.result.RepositorySummary
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    private var lastQuery: String? = null

    val service = Retrofit.Builder()
        .client(OkHttpClient())
        .baseUrl(REPOSITORY_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build().create(RemoteService::class.java)

    fun searchRepositories(
        query: String,
        searchingOption: QueryParameter.SearchingOption,
        sortingOption: QueryParameter.SortingOption
    ): Deferred<RepositorySearchResult> {

        var q = StringBuilder()
        if(searchingOption == QueryParameter.SearchingOption.BY_USER_NAME) q.append(REPOSITORY_QUALIFIER_USER_NAME)
        q.append(query)
        if(searchingOption == QueryParameter.SearchingOption.BY_REPOSITORY_NAME) q.append(REPOSITORY_QUALIFIER_REPO_NAME)
        lastQuery = q.toString()

        return service.searchRepositories(
            q.toString(),
            stringify(sortingOption)
        )
    }

    fun sortRepositories(
        sortingOption: QueryParameter.SortingOption
    ): Deferred<RepositorySearchResult>? {

        return if(lastQuery == null){
            null
        } else {
            service.searchRepositories(
                lastQuery!!,
                stringify(sortingOption)
            )
        }



    }

    private fun stringify(sortingOption: QueryParameter.SortingOption): String {
        return when (sortingOption) {
            QueryParameter.SortingOption.BEST_MATCH -> REPOSITORY_SORT_BEST_MATCH
            QueryParameter.SortingOption.STARS -> REPOSITORY_SORT_STARS
            else -> REPOSITORY_SORT_LATEST_COMMIT
        }
    }

}