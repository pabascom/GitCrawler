package phil.homework.gitcrawler.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import phil.homework.gitcrawler.model.data.remote.QueryParameter
import phil.homework.gitcrawler.model.data.remote.RemoteDataSource
import phil.homework.gitcrawler.ui.activity.MainActivity
import phil.homework.gitcrawler.ui.interaction.searchrepositories.RepositorySearchContract

class RepositorySearchPresenter(private val parentActivity: MainActivity?): RepositorySearchContract.Presenter {

    private var searchView: RepositorySearchContract.SearchView? = null
    private var listView: RepositorySearchContract.ListView? = null

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val dataSource = RemoteDataSource()

    override fun attachView(view: RepositorySearchContract.SearchView) {
        this.searchView = view
        this.listView = parentActivity?.instantiateListViewFragment(this)
    }

    override fun detachView() {
        this.searchView = null
        this.listView = null
    }

    override fun processSearchRequest(
        query: String,
        searchingParameter: QueryParameter.SearchingOption,
        sortingParameter: QueryParameter.SortingOption
    ) {
        coroutineScope.launch {
            val results = withContext(Dispatchers.Default) {
                dataSource.searchRepositoriesAsync(
                    query,
                    searchingParameter,
                    sortingParameter
                )
            }
            listView?.setContents(results.await().items)
        }
    }

    override fun processSortRequest(sortingParameter: QueryParameter.SortingOption) {
        coroutineScope.launch {
            val results = withContext(Dispatchers.Default) {
                dataSource.sortRepositoriesAsync(sortingParameter)
            }
            if(results != null) listView?.setContents(results.await().items)
        }
    }
}