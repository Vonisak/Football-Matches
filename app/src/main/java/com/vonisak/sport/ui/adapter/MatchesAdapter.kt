package com.vonisak.sport.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vonisak.sport.R
import com.vonisak.sport.domain.entity.MatchData
import com.vonisak.sport.ui.viewholder.MatchItemViewHolder

class MatchesAdapter(
    private val glide: GlideAdapter,
    private val onMatchClick: (matchId: Int) -> Unit
) : RecyclerView.Adapter<MatchItemViewHolder>() {

    var matches: List<MatchData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_item, parent, false)
        return MatchItemViewHolder(view, glide)
    }

    override fun onBindViewHolder(holder: MatchItemViewHolder, position: Int) {
        holder.bind(matches[position], onMatchClick)
    }

    override fun getItemCount(): Int = matches.size
}