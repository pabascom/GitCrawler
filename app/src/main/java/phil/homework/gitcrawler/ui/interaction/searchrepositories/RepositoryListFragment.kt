package phil.homework.gitcrawler.ui.interaction.searchrepositories

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import phil.homework.gitcrawler.R
import phil.homework.gitcrawler.model.entity.result.RepositorySummary

private const val ARG_ADAPTER = "adapter"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RepositoryListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RepositoryListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RepositoryListFragment : Fragment(), RepositorySearchContract.ListView {

    private var adapter: RepositoryListAdapter? = null
    private var view: RecyclerView? = null
    protected var presenter: RepositorySearchContract.Presenter? = null

    //private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            adapter = it.getParcelable(ARG_ADAPTER)
        }

    }

    override fun setContents(list: List<RepositorySummary>?) {
        if (list == null) {
            adapter?.clearContents()
        } else {
            adapter?.replaceContents(list)
        }
        adapter?.notifyDataSetChanged()
    }

    override fun addToContents(collection: Collection<RepositorySummary>) {
        collection.forEach{adapter?.addToContents(it)}
        adapter?.notifyDataSetChanged()
    }

    override fun addToContents(item: RepositorySummary) {
        adapter?.addToContents(item)
        adapter?.notifyDataSetChanged()
    }

    override fun showError(error: String) {
        Log.d(RepositoryListFragment::class.java.simpleName, "showError: $error")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_repository_list, container, false) as RecyclerView
        if (adapter == null) adapter = RepositoryListAdapter()

        view!!.adapter = adapter
        view!!.layoutManager = LinearLayoutManager(activity)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
//        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(presenter: RepositorySearchContract.Presenter) =
            RepositoryListFragment().apply {
                this.presenter = presenter
            }
    }
}
