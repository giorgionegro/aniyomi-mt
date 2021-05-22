package eu.kanade.tachiyomi.ui.recent.animehistory

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractSectionableItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.data.database.models.AnimeEpisodeHistory
import eu.kanade.tachiyomi.ui.recent.DateSectionItem

class AnimeHistoryItem(val mch: AnimeEpisodeHistory, header: DateSectionItem) :
    AbstractSectionableItem<AnimeHistoryHolder, DateSectionItem>(header) {

    override fun getLayoutRes(): Int {
        return R.layout.anime_history_item
    }

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>): AnimeHistoryHolder {
        return AnimeHistoryHolder(view, adapter as AnimeHistoryAdapter)
    }

    override fun bindViewHolder(
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>,
        holder: AnimeHistoryHolder,
        position: Int,
        payloads: List<Any?>?
    ) {
        holder.bind(mch)
    }

    override fun equals(other: Any?): Boolean {
        if (other is AnimeHistoryItem) {
            return mch.anime.id == other.mch.anime.id
        }
        return false
    }

    override fun hashCode(): Int {
        return mch.anime.id!!.hashCode()
    }
}