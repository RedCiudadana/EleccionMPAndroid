package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import kotlinx.android.synthetic.main.candidate_list_item.view.*

/**
 * Created by javier on 1/27/18.
 */

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val candidateImage: ImageView
        get() = view.candidate_item_image
    val candidateText: TextView
        get() = view.candidate_item_text

    var onClickListener: View.OnClickListener? = null
    set(value) {
        field = value
        view.setOnClickListener(field)
    }

}

class CandidateListAdapter(
        private val context: Context,
        private val candidateView: CandidatesContract.View,
        candidateList: List<Profile>?) : RecyclerView.Adapter<ViewHolder>() {

    var candidateList: List<Profile>? = candidateList
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.candidate_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return candidateList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val candidate = candidateList?.get(position)
        if (holder != null && candidate != null) {
            Picasso.with(context).load(candidate.fotoUrl).into(holder.candidateImage)
            holder.candidateText.text = candidate.nombre
            holder.onClickListener = View.OnClickListener {
                candidateView.onCandidateSelected(candidate)
            }
        }
    }


}