package phil.homework.gitcrawler.ui.interaction.searchrepositories

import phil.homework.gitcrawler.model.data.remote.QueryParameter
import phil.homework.gitcrawler.model.entity.repository.Repository
import phil.homework.gitcrawler.model.entity.result.RepositorySummary
import phil.homework.gitcrawler.ui.base.BasePresenter
import phil.homework.gitcrawler.ui.base.BaseView

interface RepositorySearchContract {

    interface SearchView: BaseView {

        fun reset()

    }

    interface ListView : BaseView {

        fun setContents(list: List<RepositorySummary>?)

        fun addToContents(collection: Collection<RepositorySummary>)

        fun addToContents(item: RepositorySummary)

    }

    interface Presenter : BasePresenter<SearchView> {

        fun processSearchRequest(
            query: String,
            searchingParameter: QueryParameter.SearchingOption,
            sortingParameter: QueryParameter.SortingOption
        )

        fun processSortRequest(sortingParameter: QueryParameter.SortingOption)

    }
}