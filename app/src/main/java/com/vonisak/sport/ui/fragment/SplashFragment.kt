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
import com.vonisak.sport.presentation.entity.State
import com.vonisak.sport.presentation.viewmodel.MatchListViewModel
import com.vonisak.sport.ui.activity.MainActivity


class SplashFragment : Fragment() {

    private val viewModel: MatchListViewModel by viewModels {
        ((activity as MainActivity).application as MainApp).appComponent.viewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        observeViewModel()
        viewModel.getMatches(1193)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun observeViewModel() {
        viewModel.matchesLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Success -> {
                    requireActivity().supportFragmentManager.beginTransaction().apply {
                        setCustomAnimations(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left
                        )
                        replace(R.id.container, MatchesFragment(state.data))
                        commit()
                    }

                }
                is State.Fail -> {
                    Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}