package com.codelap.waglegamoon.ui.matching

import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentMatchingBinding

class MatchingFragment : BaseFragment<FragmentMatchingBinding>(R.layout.fragment_matching) {
    override fun setLayout() {
        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            btnMatchingSuccess.setOnClickListener {
                val action = MatchingFragmentDirections.actionNavigationMatchingToNavigationMatchingRockPaperScissorsFragmen()
                findNavController().navigate(action)
            }
        }
    }
}