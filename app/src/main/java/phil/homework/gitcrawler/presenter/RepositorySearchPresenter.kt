package phil.homework.gitcrawler.presenter

import android.app.Activity
import phil.homework.gitcrawler.model.data.remote.QueryParameter
import phil.homework.gitcrawler.ui.interaction.searchrepositories.RepositorySearchContract
import phil.homework.gitcrawler.util.toast

class RepositorySearchPresenter(private val parentActivity: Activity?): RepositorySearchContract.Presenter {

    private var searchView: RepositorySearchContract.SearchView? = null
    private var listView: RepositorySearchContract.ListView? = null

    override fun attachView(view: RepositorySearchContract.SearchView) {
        this.searchView = view
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
        parentActivity?.toast("Searching for $query ${searchingParameter.name}")
    }

    override fun processSortRequest(sortingParameter: QueryParameter.SortingOption) {
        parentActivity?.toast("Sorting by $sortingParameter")
    }
}