package com.codelap.waglegamoon.ui.home

import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun setLayout() {
        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            btnFreePostButton.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToHomeFreePost()
                findNavController().navigate(action)
            }
            btnQuestionPostButton.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToHomeQuestionPost()
                findNavController().navigate(action)
            }
            btnStudyRecruitButton.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToHomeStudyRecruit()
                findNavController().navigate(action)
            }
        }
    }
}