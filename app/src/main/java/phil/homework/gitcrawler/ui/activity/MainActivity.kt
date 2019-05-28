package phil.homework.gitcrawler.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import phil.homework.gitcrawler.R
import phil.homework.gitcrawler.ui.interaction.searchrepositories.RepositoryListFragment
import phil.homework.gitcrawler.ui.interaction.searchrepositories.RepositorySearchContract

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun instantiateListViewFragment(presenter: RepositorySearchContract.Presenter): RepositorySearchContract.ListView {
        val fragment = RepositoryListFragment.newInstance(presenter)
        supportFragmentManager.beginTransaction()
            .add(R.id.listFragmentHolder, fragment)
            .commit()
        return fragment
    }
}
