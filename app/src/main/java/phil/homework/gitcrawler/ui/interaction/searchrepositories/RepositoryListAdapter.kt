package phil.homework.gitcrawler.ui.interaction.searchrepositories

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import phil.homework.gitcrawler.R
import phil.homework.gitcrawler.model.entity.result.RepositorySummary
import phil.homework.gitcrawler.util.inflate

class RepositoryListAdapter() : RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>(), Parcelable {
    var contents: MutableList<RepositorySummary> = mutableListOf()

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.recycler_item_repository))
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvOwnerName.text = contents[position].owner?.login
        viewHolder.tvRepoName.text = contents[position].name
//        viewHolder.tvLastUpdated.text = DateTimeUtils.formatWithStyle(
//            contents[position].updatedAt,
//            DateTimeStyle.FULL
//        )
    }

    fun replaceContents(list: List<RepositorySummary>){
        contents = list.toMutableList()
    }

    fun addToContents(item: RepositorySummary){
        contents.add(item)
    }

    fun clearContents(){
        contents = mutableListOf()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvOwnerName = itemView.findViewById<TextView>(R.id.tvOwnerName)
        val tvRepoName = itemView.findViewById<TextView>(R.id.tvRepoName)
        val tvLastUpdated = itemView.findViewById<TextView>(R.id.tvLastUpdated)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RepositoryListAdapter> {
        override fun createFromParcel(parcel: Parcel): RepositoryListAdapter {
            return RepositoryListAdapter(parcel)
        }

        override fun newArray(size: Int): Array<RepositoryListAdapter?> {
            return arrayOfNulls(size)
        }
    }
}