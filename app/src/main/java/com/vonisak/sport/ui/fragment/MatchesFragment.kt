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
import com.vonisak.sport.databinding.FragmentMatchesBinding
import com.vonisak.sport.domain.entity.MatchData
import com.vonisak.sport.presentation.entity.State
import com.vonisak.sport.presentation.viewmodel.MatchListViewModel
import com.vonisak.sport.ui.activity.MainActivity
import com.vonisak.sport.ui.adapter.GlideAdapter
import com.vonisak.sport.ui.adapter.MatchesAdapter


class MatchesFragment(private val data: List<MatchData>?) : Fragment() {

    private var _binding: FragmentMatchesBinding? = null
    private val binding get() = _binding!!
    private val adapter: MatchesAdapter = MatchesAdapter(GlideAdapter(this)) { matchId ->
        requireActivity().supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            add(R.id.container, MatchDetailsFragment(matchId))
            hide(this@MatchesFragment)
            addToBackStack(null)
            commit()
        }
    }

    private val viewModel: MatchListViewModel by viewModels {
        ((activity as MainActivity).application as MainApp).appComponent.viewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchesBinding.inflate(inflater, container, false)

        setRecycler()
        observeViewModel()

        if (data != null) {
            adapter.matches = data
        } else {
            viewModel.getMatches(1193)
        }


        return binding.root
    }

    private fun observeViewModel() {
        viewModel.matchesLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Success -> {
                    adapter.matches = state.data
                }
                is State.Fail -> {
                    Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun setRecycler() {
        binding.matchesRecycler.adapter = adapter
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}