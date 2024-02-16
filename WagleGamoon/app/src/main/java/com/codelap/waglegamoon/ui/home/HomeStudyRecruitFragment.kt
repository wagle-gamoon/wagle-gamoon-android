package com.codelap.waglegamoon.ui.home

import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentHomeStudyRecruitBinding

class HomeStudyRecruitFragment : BaseFragment<FragmentHomeStudyRecruitBinding>(R.layout.fragment_home_study_recruit) {
    override fun setLayout() {

    }

    private fun setClickListener() {
        with(binding) {
            toolbarStudy.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}