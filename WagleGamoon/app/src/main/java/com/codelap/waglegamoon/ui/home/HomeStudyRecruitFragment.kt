package com.codelap.waglegamoon.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentHomeStudyRecruitBinding
import com.codelap.waglegamoon.ui.home.adapter.PostClickListener
import com.codelap.waglegamoon.ui.home.adapter.StudyRecruitAdapter
import com.codelap.waglegamoon.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeStudyRecruitFragment : BaseFragment<FragmentHomeStudyRecruitBinding>(R.layout.fragment_home_study_recruit),
PostClickListener {
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter = StudyRecruitAdapter(this)

    override fun setLayout() {
        viewModel.getPosts(3)
        setClickListener()
        initAdapter()
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.postList.collectLatest {
                    adapter.update(it.data)
                    binding.rvStudyRecruitList.adapter = adapter
                }
            }
        }

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

    override fun onClickPost(postId: Long) {
        val action = HomeStudyRecruitFragmentDirections.actionHomeStudyRecruitToHomePostDetail()
        findNavController().navigate(action)
    }
}