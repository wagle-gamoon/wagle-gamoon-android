package com.codelap.waglegamoon.ui.home

import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun setLayout() {
        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            button5.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToHomeFreePost()
                findNavController().navigate(action)
            }
            button6.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToHomeQuestionPost()
                findNavController().navigate(action)
            }
        }
    }
}