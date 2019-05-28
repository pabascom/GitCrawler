package phil.homework.gitcrawler.ui.interaction.searchrepositories

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.fragment_repository_search.*

import phil.homework.gitcrawler.R
import phil.homework.gitcrawler.model.data.remote.QueryParameter
import phil.homework.gitcrawler.presenter.RepositorySearchPresenter
import phil.homework.gitcrawler.ui.activity.MainActivity

class RepositorySearchFragment : Fragment(), RepositorySearchContract.SearchView {

    private var presenter: RepositorySearchContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_repository_search, container, false)

        view.findViewById<Button>(R.id.btnSearch).setOnClickListener {
            presenter?.processSearchRequest(
                etQuery.text.toString(),
                when(rdgSearchOption.checkedRadioButtonId){
                    R.id.rdbRepositoryName -> QueryParameter.SearchingOption.BY_REPOSITORY_NAME
                    else -> QueryParameter.SearchingOption.BY_USER_NAME
                },
                when(rdgSortOption.checkedRadioButtonId){
                    R.id.rdbBestMatch -> QueryParameter.SortingOption.BEST_MATCH
                    R.id.rdbStars -> QueryParameter.SortingOption.STARS
                    else -> QueryParameter.SortingOption.LATEST_COMMIT
                }
            )
        }

        view.findViewById<RadioGroup>(R.id.rdgSortOption).setOnCheckedChangeListener { _, checkedId ->
            presenter?.processSortRequest(
                when(checkedId){
                    R.id.rdbBestMatch -> QueryParameter.SortingOption.BEST_MATCH
                    R.id.rdbStars -> QueryParameter.SortingOption.STARS
                    else -> QueryParameter.SortingOption.LATEST_COMMIT
                }
            )
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        val parentActivity = activity as MainActivity
        presenter = RepositorySearchPresenter(parentActivity)
        presenter?.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter?.detachView()
    }

    override fun reset() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
