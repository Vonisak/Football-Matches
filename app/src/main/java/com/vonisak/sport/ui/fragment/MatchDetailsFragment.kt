package com.vonisak.sport.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.vonisak.sport.MainApp
import com.vonisak.sport.R
import com.vonisak.sport.databinding.FragmentMatchDetailsBinding
import com.vonisak.sport.presentation.entity.State
import com.vonisak.sport.presentation.viewmodel.MatchDetailsViewModel
import com.vonisak.sport.ui.activity.MainActivity
import com.vonisak.sport.ui.adapter.GlideAdapter


class MatchDetailsFragment(private val matchId: Int) : Fragment() {

    private var _binding: FragmentMatchDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MatchDetailsViewModel by viewModels {
        ((activity as MainActivity).application as MainApp).appComponent.viewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchDetailsBinding.inflate(inflater, container, false)

        observeViewModel()
        viewModel.getMatch(matchId)

        return binding.root
    }

    private fun observeViewModel() {
        viewModel.matchLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Success -> {
                    viewModel.getLeague(state.data.leagueId)
                    viewModel.getSeason(state.data.seasonId)
                    val glide = GlideAdapter(this)
                    glide.loadImage(state.data.homeTeam.logo, binding.homeTeamLogo)
                    glide.loadImage(state.data.awayTeam.logo, binding.awayTeamLogo)
                    binding.homeName.text = state.data.homeTeam.name
                    binding.awayName.text = state.data.awayTeam.name
                    binding.fullTimeScore.text = state.data.stats.ftScore
                    binding.status.text = state.data.status
                    binding.group.text = state.data.group.name
                    binding.betBoomLink.setOnClickListener(onLinkClick())
                    binding.oneXLink.setOnClickListener(onLinkClick())
                    binding.fonbetLink.setOnClickListener(onLinkClick())
                    val homeStat = state.data.matchStatistics?.get(0)
                    val awayStat = state.data.matchStatistics?.get(0)

                    if (homeStat != null && awayStat != null) {
                        binding.matchStatistics.homeCorners.text = homeStat.corners.toString()
                        binding.matchStatistics.awayCorners.text = awayStat.corners.toString()

                        binding.matchStatistics.homeFouls.text = homeStat.fouls.toString()
                        binding.matchStatistics.awayFouls.text = awayStat.fouls.toString()

                        binding.matchStatistics.homeOffsides.text = homeStat.offsides.toString()
                        binding.matchStatistics.awayOffsides.text = awayStat.offsides.toString()

                        binding.matchStatistics.homePenalties.text = homeStat.penalties.toString()
                        binding.matchStatistics.awayPenalties.text = awayStat.penalties.toString()

                        binding.matchStatistics.homeShotsBlocked.text = homeStat.shotsBlocked.toString()
                        binding.matchStatistics.awayShotsBlocked.text = awayStat.shotsBlocked.toString()

                        binding.matchStatistics.homeShotsOffTarget.text = homeStat.shotsOffTarget.toString()
                        binding.matchStatistics.awayShotsOffTarget.text = awayStat.shotsOffTarget.toString()

                        binding.matchStatistics.homeShotsTotal.text = homeStat.shotsTotal.toString()
                        binding.matchStatistics.awayShotsTotal.text = awayStat.shotsTotal.toString()
                    }
                }
                is State.Fail -> {
                    Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        viewModel.leagueLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Success -> {
                    binding.league.text = state.data.data.name
                }
                is State.Fail -> {
                    Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        viewModel.seasonLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Success -> {
                    binding.season.text = state.data.name
                }
                is State.Fail -> {
                    Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun onLinkClick() = View.OnClickListener {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            add(R.id.container, WebViewFragment())
            addToBackStack(null)
            commit()
        }
    }

}