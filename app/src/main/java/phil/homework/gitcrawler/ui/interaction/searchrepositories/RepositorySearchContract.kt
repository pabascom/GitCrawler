package phil.homework.gitcrawler.ui.interaction.searchrepositories

import phil.homework.gitcrawler.model.data.remote.QueryParameter
import phil.homework.gitcrawler.model.entity.repository.Repository
import phil.homework.gitcrawler.ui.base.BasePresenter
import phil.homework.gitcrawler.ui.base.BaseView

interface RepositorySearchContract {

    interface SearchView: BaseView {

        fun reset()

    }

    interface ListView : BaseView {

        fun setContents(list: List<Repository>)

        fun addToContents(collection: Collection<Repository>)

        fun addToContents(item: Repository)

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