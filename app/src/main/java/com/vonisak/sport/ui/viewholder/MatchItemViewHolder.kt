package com.vonisak.sport.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vonisak.sport.databinding.MatchItemBinding
import com.vonisak.sport.domain.entity.MatchData
import com.vonisak.sport.ui.adapter.GlideAdapter

class MatchItemViewHolder(view: View, private val glideAdapter: GlideAdapter) :
    RecyclerView.ViewHolder(view) {
    private val binding = MatchItemBinding.bind(view)

    fun bind(match: MatchData, onMatchClick: (matchId: Int) -> Unit) = with(binding) {

        glideAdapter.loadImage(match.homeTeam.logo, homeTeamLogo)
        glideAdapter.loadImage(match.awayTeam.logo, awayTeamLogo)
        homeName.text = match.homeTeam.name
        awayName.text = match.awayTeam.name
        fullTimeScore.text = match.stats.ftScore
        roundName.text = match.round.name
        stageName.text = match.stage.name

        card.setOnClickListener {
            onMatchClick(match.id)
        }
    }
}