package eleccionmp.redciudadana.org.eleccionmp.views.commission

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
import kotlinx.android.synthetic.main.candidate_list_item.view.*

/**
 * Created by javier on 2/1/18.
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

class CommissionListAdapter(
        private val context: Context,
        private val commissionView: CommissionContract.View,
        candidateList: List<Models.Profile>?) : RecyclerView.Adapter<ViewHolder>() {

    var commissionList: List<Models.Profile>? = candidateList
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.candidate_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commissionList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val candidate = commissionList?.get(position)
        if (holder != null && candidate != null) {
            Picasso.with(context).load(candidate.fotoUrl).into(holder.candidateImage)
            holder.candidateText.text = candidate.nombre
            holder.onClickListener = View.OnClickListener {
                commissionView.onCommissionPersonSelected(candidate)
            }
        }
    }


}