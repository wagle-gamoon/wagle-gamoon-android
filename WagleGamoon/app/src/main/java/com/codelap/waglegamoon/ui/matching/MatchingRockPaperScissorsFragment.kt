package com.codelap.waglegamoon.ui.matching

import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentMatchingRockPaperScissorsFragmentBinding

class MatchingRockPaperScissorsFragment : BaseFragment<FragmentMatchingRockPaperScissorsFragmentBinding>(
    R.layout.fragment_matching_rock_paper_scissors_fragment) {

    private var userState = ""

    override fun setLayout() {
        setClickListener()
        with(binding) {
            ivPaper.setOnClickListener {
                btnPaper.isEnabled = true
                btnRock.isEnabled = false
                btnScissors.isEnabled = false
            }
            ivScissors.setOnClickListener {
                btnScissors.isEnabled = true
                btnRock.isEnabled = false
                btnPaper.isEnabled = false
            }
            ivRock.setOnClickListener {
                btnRock.isEnabled = true
                btnPaper.isEnabled = false
                btnScissors.isEnabled = false
            }
        }
    }

    private fun setClickListener() {
        with(binding) {
            toolbarRockPaper.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}