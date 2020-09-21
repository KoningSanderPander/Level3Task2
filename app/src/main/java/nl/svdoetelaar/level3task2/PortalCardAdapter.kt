package nl.svdoetelaar.level3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portal_card.view.*

class PortalCardAdapter(private val portalCards: List<PortalCard>) :
    RecyclerView.Adapter<PortalCardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun dataBind(portalCard: PortalCard) {
            itemView.tvTitle.text = portalCard.title
            itemView.tvLink.text = portalCard.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.portal_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(portalCards[position])
    }

    override fun getItemCount(): Int {
        return portalCards.size
    }
}
