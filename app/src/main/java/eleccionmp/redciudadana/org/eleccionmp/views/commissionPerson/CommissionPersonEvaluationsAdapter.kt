package eleccionmp.redciudadana.org.eleccionmp.views.commissionPerson

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import kotlinx.android.synthetic.main.candidate_evaluation_list_item.view.*

/**
 * Created by javier on 2/5/18.
 */

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val candidateImage: ImageView
        get() = view.candidate_item_image
    val candidateText: TextView
        get() = view.candidate_item_text
    val candidateScore: TextView
        get() = view.candidate_item_score
}


class CommissionPersonEvaluationsAdapter(
        private val context: Context,
        candidatesList: List<Models.EvaluationResult>?
) : RecyclerView.Adapter<ViewHolder>() {

    var candidatesList: List<Models.EvaluationResult>? = candidatesList
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.candidate_evaluation_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return candidatesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val candidate = candidatesList!![position]
        if (holder != null) {
            Picasso.with(context).load(candidate.perfil.fotoUrl).into(holder.candidateImage)
            holder.candidateText.text = candidate.perfil.nombre
            holder.candidateScore.text = candidate.resultado
        }
    }

}