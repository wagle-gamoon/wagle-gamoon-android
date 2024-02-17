package com.codelap.waglegamoon.ui.home

import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.data.local.Datasource
import com.codelap.waglegamoon.databinding.FragmentHomeStudyRecruitBinding
import com.codelap.waglegamoon.ui.home.adapter.PostClickListener
import com.codelap.waglegamoon.ui.home.adapter.StudyRecruitAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeStudyRecruitFragment : BaseFragment<FragmentHomeStudyRecruitBinding>(R.layout.fragment_home_study_recruit),
PostClickListener {
    private val adapter = StudyRecruitAdapter(this)

    override fun setLayout() {
        setClickListener()
        initAdapter()
    }

    private fun initAdapter() {
        adapter.update(Datasource.getPostStudyList())
        binding.rvStudyRecruitList.adapter = adapter

    }

    private fun setClickListener() {
        with(binding) {
            toolbarStudy.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
            ibPostWriteButton.setOnClickListener {
                val action = HomeStudyRecruitFragmentDirections.actionHomeStudyRecruitToHomeStudyRecruitWrite()
                findNavController().navigate(action)
            }
        }
    }

    override fun onClickPost() {
        val action = HomeStudyRecruitFragmentDirections.actionHomeStudyRecruitToHomePostDetail()
        findNavController().navigate(action)
    }
}