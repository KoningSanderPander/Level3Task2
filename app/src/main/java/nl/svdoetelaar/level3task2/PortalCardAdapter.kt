package nl.svdoetelaar.level3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nl.svdoetelaar.level3task2.databinding.PortalCardBinding

class PortalCardAdapter(private val portalCards: List<PortalCard>, private val clickListener:(PortalCard) -> Unit) :
    RecyclerView.Adapter<PortalCardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = PortalCardBinding.bind(itemView)

        fun dataBind(portalCard: PortalCard, clickListener: (PortalCard) -> Unit) {
            binding.tvTitle.text = portalCard.title
            binding.tvLink.text = portalCard.url
            binding.cardView.setOnClickListener{clickListener(portalCard)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.portal_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(portalCards[position], clickListener = clickListener)
    }

    override fun getItemCount(): Int {
        return portalCards.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.dataBind(portalCards[position], clickListener)
    }
}
